package controllers;

import controllers.modelFx.CarFX;
import controllers.modelFx.CarListModel;
import controllers.modelFx.CarModel;
import database.Car;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CarCompariseController {
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField brandTextField;
    @FXML
    public TextField mpgTextField;
    @FXML
    public TextField cylindersTextField;
    @FXML
    public TextField horsepowerTextField;
    @FXML
    public TextField weightTextField;
    @FXML
    public TextField accelerationTextField;
    @FXML
    public TextField yearTextField;
    @FXML
    public ComboBox brandComboBox;
    @FXML
    public ComboBox nameComboBox;
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
    public TableColumn<CarFX, Number> mpgColumn;
    @FXML
    public TableColumn<CarFX, Number> cylindersColumn;
    @FXML
    public TableColumn<CarFX, Number> horsepowerColumn;
    @FXML
    public TableColumn<CarFX, Number> weightColumn;
    @FXML
    public TableColumn<CarFX, Number> accelerationColumn;
    @FXML
    public TableColumn<CarFX, Number> yearColumn;
    @FXML
    public TableColumn<CarFX, Number> originColumn;
    @FXML
    public TableColumn<CarFX, String> brandColumn;
    @FXML
    public TableColumn<CarFX, String> nameColumn;
    @FXML
    public TableView<CarFX> carsTableView;
    @FXML
    public TableColumn<CarFX, CarFX> editColumn;
    @FXML
    public TableColumn<CarFX, CarFX> compariseColumn;
    @FXML
    public TableColumn<CarFX, CarFX> deleteColumn;
    @FXML
    public Button backButton;


    private CarModel carModel;

    private CarListModel carListModel;

    @FXML
    public void initialize() {

        this.carListModel = new CarListModel();
        this.carListModel.init();

        setItemsInComboBoxes();
        bingPropertiesWithComboBoxes();

        setCellValuesInTable();

    }

    @FXML
    private void compariseCars() {
        if (carsTableView.getSelectionModel().getSelectedItem() != null) {

            colorTextFieldsComparision();

            saveInTextFile();

        }
    }

    private void saveInTextFile() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("comparision.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write("1 car name: " + nameTextField.textProperty().getValue() + " | and 2 car name: " +carsTableView.getSelectionModel().getSelectedItem().getName());
            bw.newLine();
            bw.write("1 car brand: "+brandTextField.textProperty().getValue()+" | and 2 car brand: "+carsTableView.getSelectionModel().getSelectedItem().getBrand());
            bw.newLine();
            bw.write("1 car mpg: "+mpgTextField.textProperty().getValue()+" | and 2 car mpg: "+carsTableView.getSelectionModel().getSelectedItem().getMpg());
            bw.newLine();
            bw.write("1 car cylinders: "+cylindersTextField.textProperty().getValue()+" | and 2 car cylinders: "+carsTableView.getSelectionModel().getSelectedItem().getCylinders());
            bw.newLine();
            bw.write("1 car horsepower: "+horsepowerTextField.textProperty().getValue()+" | and 2 car horsepower: "+carsTableView.getSelectionModel().getSelectedItem().getHorsepower());
            bw.newLine();
            bw.write("1 car weight: "+weightTextField.textProperty().getValue()+" | and 2 car weight: "+carsTableView.getSelectionModel().getSelectedItem().getWeight());
            bw.newLine();
            bw.write("1 car acceleration: "+accelerationTextField.textProperty().getValue()+" | and 2 car acceleration: "+carsTableView.getSelectionModel().getSelectedItem().getAcceleration());
            bw.newLine();
            bw.write("1 car year: "+yearTextField.textProperty().getValue()+" | and 2 car year: "+carsTableView.getSelectionModel().getSelectedItem().getYear());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void colorTextFieldsComparision() {
            if (carsTableView.getSelectionModel().getSelectedItem().getMpg() > Double.valueOf(mpgTextField.textProperty().getValue())) {
                mpgTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getMpg() < Double.valueOf(mpgTextField.textProperty().getValue())) {
                mpgTextField.setStyle("-fx-text-fill: green");
            }
            if (carsTableView.getSelectionModel().getSelectedItem().getCylinders() > Integer.valueOf(cylindersTextField.textProperty().getValue())) {
                cylindersTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getCylinders() < Integer.valueOf(cylindersTextField.textProperty().getValue())) {
                cylindersTextField.setStyle("-fx-text-fill: green");
            }
            if (carsTableView.getSelectionModel().getSelectedItem().getHorsepower() > Integer.valueOf(horsepowerTextField.textProperty().getValue())) {
                horsepowerTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getHorsepower() < Integer.valueOf(horsepowerTextField.textProperty().getValue())) {
                horsepowerTextField.setStyle("-fx-text-fill: green");
            }
            if (carsTableView.getSelectionModel().getSelectedItem().getWeight() > Integer.valueOf(weightTextField.textProperty().getValue())) {
                weightTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getWeight() < Integer.valueOf(weightTextField.textProperty().getValue())) {
                weightTextField.setStyle("-fx-text-fill: green");
            }
            if (carsTableView.getSelectionModel().getSelectedItem().getAcceleration() > Double.valueOf(accelerationTextField.textProperty().getValue())) {
                accelerationTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getAcceleration() < Double.valueOf(accelerationTextField.textProperty().getValue())) {
                accelerationTextField.setStyle("-fx-text-fill: green");
            }
            if (carsTableView.getSelectionModel().getSelectedItem().getYear() > Integer.valueOf(yearTextField.textProperty().getValue())) {
                yearTextField.setStyle("-fx-text-fill: red");
            } else if (carsTableView.getSelectionModel().getSelectedItem().getYear() < Integer.valueOf(yearTextField.textProperty().getValue())) {
                yearTextField.setStyle("-fx-text-fill: green");
            }
        }


    private void setCellValuesInTable() {
        this.carsTableView.setItems(this.carListModel.getCarFXObservableList());
        this.mpgColumn.setCellValueFactory(cellData -> cellData.getValue().mpgProperty());
        this.cylindersColumn.setCellValueFactory(cellData -> cellData.getValue().cylindersProperty());
        this.horsepowerColumn.setCellValueFactory(cellData -> cellData.getValue().horsepowerProperty());
        this.weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
        this.accelerationColumn.setCellValueFactory(cellData -> cellData.getValue().accelerationProperty());
        this.yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        this.originColumn.setCellValueFactory(cellData -> cellData.getValue().originProperty());
        this.brandColumn.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.deleteColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.editColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
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


    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
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

    public void backToCarList() {
        Stage stage= (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
