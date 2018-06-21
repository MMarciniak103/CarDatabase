package controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import utils.exceptions.DialogUtils;
import utils.exceptions.FxmlUtils;


import java.util.Optional;

public class MainController {

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private TopMenuController topMenuButtonsController;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath) {
        borderPaneMain.setCenter(FxmlUtils.fxmLoader(fxmlPath));
    }


    public void closeApplication() {
        Optional<ButtonType> result = DialogUtils.confirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void about() {
        DialogUtils.DialogAboutApplication();
    }

    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }
}
