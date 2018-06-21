package controllers;


import controllers.modelFx.CarFX;
import controllers.modelFx.CarListModel;
import controllers.modelFx.CarModel;
import database.Car;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.exceptions.DialogUtils;
import utils.exceptions.FxmlUtils;

import java.io.IOException;


public class CarsListController  {

    @FXML
    public TableColumn<CarFX,Number> mpgColumn;
    @FXML
    public TableColumn<CarFX,Number> cylindersColumn;
    @FXML
    public TableColumn<CarFX,Number> horsepowerColumn;
    @FXML
    public TableColumn<CarFX,Number> weightColumn;
    @FXML
    public TableColumn<CarFX,Number> accelerationColumn;
    @FXML
    public TableColumn<CarFX,Number> yearColumn;
    @FXML
    public TableColumn<CarFX,Number> originColumn;
    @FXML
    public TableColumn<CarFX,String> brandColumn;
    @FXML
    public TableColumn<CarFX,String> nameColumn;
    @FXML
    public TableView<CarFX> carsTableView;
    @FXML
    public ComboBox nameComboBox;
    @FXML
    public ComboBox brandComboBox;
    @FXML
    public TableColumn<CarFX,CarFX> deleteColumn;
    @FXML
    public TableColumn<CarFX,CarFX> editColumn;
    @FXML
    public ComboBox mpgComboBox;
    @FXML
    public ComboBox cylindersComboBox;
    @FXML
    public ComboBox horsePowerComboBox;
    @FXML
    public ComboBox weightComboBox;
    @FXML
    public ComboBox accelerationComboBox;
    @FXML
    public ComboBox yearComboBox;
    @FXML
    public ComboBox originComboBox;
    @FXML
    public TableColumn<CarFX,CarFX> compariseColumn;

    public CarListModel carListModel;


    @FXML
    void initialize(){
        this.carListModel=new CarListModel();
        this.carListModel.init();

        setItemsInComboBoxes();
        bingPropertiesWithComboBoxes();

        setCellValuesInTable();

        this.deleteColumn.setCellFactory(param -> new TableCell<CarFX,CarFX>(){
            Button button=createButton("/icons/delete.png");

            @Override
            protected void updateItem(CarFX item, boolean empty) {
                super.updateItem(item, empty);
                button.disableProperty().bind(Bindings.isNull(carsTableView.getSelectionModel().selectedItemProperty()));

                if(empty){
                    setGraphic(null);
                    return;
                }
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        carListModel.deleteCar(item);
                    });
                }
            }
        });


        this.editColumn.setCellFactory(param -> new TableCell<CarFX,CarFX>(){
            Button button=createButton("/icons/edit.png");

            @Override
            protected void updateItem(CarFX item, boolean empty) {
                super.updateItem(item, empty);
                button.disableProperty().bind(Bindings.isNull(carsTableView.getSelectionModel().selectedItemProperty()));


                if(empty){
                    setGraphic(null);
                    return;
                }
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader= FxmlUtils.getLoader("/fxml/AddCar.fxml");
                        Scene scene=null;
                        try {
                            scene=new Scene(loader.load());
                        } catch (IOException e) {
                            DialogUtils.errorDialog(e.getMessage());
                        }
                        CarController controller=loader.getController();
                        controller.getCarModel().setCarFXObjectProperty(item);
                        controller.bindings();
                        Stage stage=new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();
                    });
                }
            }
        });

        this.compariseColumn.setCellFactory(param -> new TableCell<CarFX,CarFX>(){
            Button button=createButton("/icons/comparise1.png");



            @Override
            protected void updateItem(CarFX item, boolean empty) {
                super.updateItem(item, empty);
                button.disableProperty().bind(Bindings.isNull(carsTableView.getSelectionModel().selectedItemProperty()));


                if(empty){
                    setGraphic(null);
                    return;
                }
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader=FxmlUtils.getLoader("/fxml/CompariseCar.fxml");
                        Scene scene=null;
                        try {
                            scene=new Scene(loader.load());
                        } catch (IOException e) {
                            DialogUtils.errorDialog(e.getMessage());
                        }
                        CarCompariseController controller=loader.getController();
                        if(carsTableView.getSelectionModel().getSelectedItem()!=null) {
                            CarFX carFX1 = carsTableView.getSelectionModel().getSelectedItem();
                            controller.nameTextField.textProperty().setValue(carFX1.getName());
                            controller.brandTextField.textProperty().setValue(carFX1.getBrand());
                            controller.mpgTextField.textProperty().setValue(String.valueOf(carFX1.getMpg()));
                            controller.cylindersTextField.textProperty().setValue(String.valueOf(carFX1.getCylinders()));
                            controller.horsepowerTextField.textProperty().setValue(String.valueOf(carFX1.getHorsepower()));
                            controller.weightTextField.textProperty().setValue(String.valueOf(carFX1.getWeight()));
                            controller.accelerationTextField.textProperty().setValue(String.valueOf(carFX1.getAcceleration()));
                            controller.yearTextField.textProperty().setValue(String.valueOf(carFX1.getYear()));
                        }

                        Stage stage=new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();
                    });
                }
            }
        });


    }

    private void setCellValuesInTable() {
        this.carsTableView.setItems(this.carListModel.getCarFXObservableList());
        this.mpgColumn.setCellValueFactory(cellData-> cellData.getValue().mpgProperty());
        this.cylindersColumn.setCellValueFactory(cellData-> cellData.getValue().cylindersProperty());
        this.horsepowerColumn.setCellValueFactory(cellData-> cellData.getValue().horsepowerProperty());
        this.weightColumn.setCellValueFactory(cellData-> cellData.getValue().weightProperty());
        this.accelerationColumn.setCellValueFactory(cellData-> cellData.getValue().accelerationProperty());
        this.yearColumn.setCellValueFactory(cellData-> cellData.getValue().yearProperty());
        this.originColumn.setCellValueFactory(cellData-> cellData.getValue().originProperty());
        this.brandColumn.setCellValueFactory(cellData-> cellData.getValue().brandProperty());
        this.nameColumn.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        this.deleteColumn.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.getValue()));
        this.editColumn.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.getValue()));
    }

    private void bingPropertiesWithComboBoxes() {
        this.carListModel.carBrandObjectProperty().bind(this.brandComboBox.valueProperty());
        this.carListModel.carNameObjectProperty().bind(this.nameComboBox.valueProperty());
        this.carListModel.carMpgObjetProperty().bind(this.mpgComboBox.valueProperty());
        this.carListModel.carCylindersObjectProperty().bind(this.cylindersComboBox.valueProperty());
        this.carListModel.carHorsepowerObjectProperty().bind(this.horsePowerComboBox.valueProperty());
        this.carListModel.carWeightObjectProperty().bind(this.weightComboBox.valueProperty());
        this.carListModel.carAccelerationObjectProperty().bind(this.accelerationComboBox.valueProperty());
        this.carListModel.carYearObjectProperty().bind(this.yearComboBox.valueProperty());
        this.carListModel.carOriginObjectProperty().bind(this.originComboBox.valueProperty());
    }

    private void setItemsInComboBoxes() {
        this.nameComboBox.setItems(this.carListModel.getCarName());
        this.brandComboBox.setItems(this.carListModel.getCarBrand());
        this.mpgComboBox.setItems(this.carListModel.getCarMpg());
        this.cylindersComboBox.setItems(this.carListModel.getCarCylinders());
        this.horsePowerComboBox.setItems(this.carListModel.getCarHorsepower());
        this.weightComboBox.setItems(this.carListModel.getCarWeight());
        this.accelerationComboBox.setItems(this.carListModel.getCarAcceleration());
        this.yearComboBox.setItems(this.carListModel.getCarYear());
        this.originComboBox.setItems(this.carListModel.getCarOrigin());
    }



    private Button createButton(String path){
        Button button=new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);

        return button;
    }


    public CarListModel getCarListModel() {
        return carListModel;
    }

    public void setCarListModel(CarListModel carListModel) {
        this.carListModel = carListModel;
    }

    public void filterOnActionComboBox() {
        this.carListModel.filterCarList();
    }

    public void clearBrandComboBox() {
        this.brandComboBox.getSelectionModel().clearSelection();
    }

    public void clearNameComboBox() {
        this.nameComboBox.getSelectionModel().clearSelection();
    }

    public void clearMpgComboBox() {
        this.mpgComboBox.getSelectionModel().clearSelection();
    }

    public void clearCylindersComboBox() {
        this.cylindersComboBox.getSelectionModel().clearSelection();
    }

    public void clearHorsePowerComboBox() {
        this.horsePowerComboBox.getSelectionModel().clearSelection();
    }

    public void clearWeightComboBox() {
        this.weightComboBox.getSelectionModel().clearSelection();
    }

    public void clearAccelerationComboBox() {
        this.accelerationComboBox.getSelectionModel().clearSelection();
    }

    public void clearYearComboBox() {
        this.yearComboBox.getSelectionModel().clearSelection();
    }

    public void clearOriginComboBox() {
        this.originComboBox.getSelectionModel().clearSelection();
    }
}
