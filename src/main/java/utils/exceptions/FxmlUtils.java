package utils.exceptions;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FxmlUtils{

    public static Pane fxmLoader(String fxmlPath){
        FXMLLoader fxmlLoader=new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        try {
            return fxmlLoader.load();
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
        return null;
    }

    public static FXMLLoader getLoader(String fxmlPath){
        FXMLLoader fxmlLoader=new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        return  fxmlLoader;
    }
}
