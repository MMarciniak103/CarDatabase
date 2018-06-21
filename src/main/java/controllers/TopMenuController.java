package controllers;

import javafx.event.ActionEvent;

public class TopMenuController  {

    private final String ADD_CAR_FXML="/fxml/AddCar.fxml";
    private final String CAR_LIST_FXML="/fxml/CarsList.fxml";

    private MainController mainController;

    public void showCarDatabase() {
        mainController.setCenter(CAR_LIST_FXML);
    }


    public void addCar() {
        mainController.setCenter(ADD_CAR_FXML);
    }

    public  void setMainController(MainController mainController){
        this.mainController=mainController;
    }
}
