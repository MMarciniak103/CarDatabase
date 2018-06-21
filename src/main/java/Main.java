import database.DbManager;
import database.FillDatabase;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.exceptions.FxmlUtils;



public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML="/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        Pane borderPane= FxmlUtils.fxmLoader(BORDER_PANE_MAIN_FXML);
        Scene scene=new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CarsDatabase Application");
        primaryStage.show();

        DbManager.initDatabase();
        //FillDatabase.fillDatabase(); //baza danych zostala wypelniona przy pierwszym uruchomieniu
    }


}
