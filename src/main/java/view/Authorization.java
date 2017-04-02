package view;

import controller.WindowController;
import javafx.application.Application;
import javafx.stage.Stage;



/**
 * Created on 27.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class Authorization extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        WindowController.getAuthorizationStage().show();
    }
}
