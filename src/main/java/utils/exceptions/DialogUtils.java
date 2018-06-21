package utils.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;

public class DialogUtils {

    public static void errorDialog(String error){
        Alert errorAlert=new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("APPLICATION ERROR");
        errorAlert.setHeaderText("Something gone wrong...");

        TextArea textArea=new TextArea();
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

    public static void DialogAboutApplication(){
        Alert informationAlert=new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About application");
        informationAlert.setHeaderText("My CarDatabase Application -version 1.0");
        informationAlert.setContentText("Application was made as an academic project for programming course");
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Exit");
        confirmationDialog.setHeaderText("Are you sure you want to exit?");
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }


}
