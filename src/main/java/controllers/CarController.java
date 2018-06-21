package controllers;


import controllers.modelFx.CarModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class CarController {
    @FXML
    public TextField mpgTextField;
    @FXML
    public TextField cylindersTextField;
    @FXML
    public TextField displacementTextField;
    @FXML
    public TextField horsePowerTextField;
    @FXML
    public TextField weightTextField;
    @FXML
    public TextField accelerationTextField;
    @FXML
    public TextField yearTextField;
    @FXML
    public TextField originTextField;
    @FXML
    public TextField brandTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public Button addButton;

    private CarModel carModel;


    @FXML
    public void initialize() {
        this.carModel=new CarModel();
        this.carModel.init();
        bindings();
        validation();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.mpgTextField.textProperty().isEmpty().
                or(this.cylindersTextField.textProperty().isEmpty()).
                or(this.displacementTextField.textProperty().isEmpty()).
                or(this.horsePowerTextField.textProperty().isEmpty()).
                or(this.weightTextField.textProperty().isEmpty()).
                or(this.accelerationTextField.textProperty().isEmpty()).
                or(this.yearTextField.textProperty().isEmpty()).or(this.originTextField.textProperty().isEmpty().
                or(this.brandTextField.textProperty().isEmpty().or(this.nameTextField.textProperty().isEmpty()))));
    }

    public void bindings(){
       this.mpgTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().mpgProperty(), new NumberStringConverter());
       this.cylindersTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().cylindersProperty(),new NumberStringConverter());
       this.displacementTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().displacementsProperty(),new NumberStringConverter());
       this.horsePowerTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().horsepowerProperty(),new NumberStringConverter());
       this.weightTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().weightProperty(),new NumberStringConverter());
       this.accelerationTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().accelerationProperty(),new NumberStringConverter());
       this.yearTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().yearProperty(),new NumberStringConverter());
       this.originTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().originProperty(),new NumberStringConverter());
       this.brandTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().brandProperty());
       this.nameTextField.textProperty().bindBidirectional(this.carModel.getCarFXObjectProperty().nameProperty());

    }

    public void addCarOnAction() {
        this.carModel.saveCarInDatabase();

        clearFields();

    }

    private void clearFields(){
        this.mpgTextField.clear();
        this.cylindersTextField.clear();
        this.displacementTextField.clear();
        this.horsePowerTextField.clear();
        this.weightTextField.clear();
        this.accelerationTextField.clear();
        this.yearTextField.clear();
        this.brandTextField.clear();
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }
}