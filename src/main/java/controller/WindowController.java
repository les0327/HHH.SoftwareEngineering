package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Authorization;


import java.io.IOException;

/**
 * Created on 02.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class WindowController {

    private static Authorization authorization = new Authorization();

    private static Stage authorizationStage    = authorizationStage();
    private static Stage registrationStage     = registrationStage();


    static void openAuthorization(){
        authorizationStage.show();
    }

    static void openRegistration(){
        registrationStage.show();
    }

    static void hideAuthorization(){
        authorizationStage.hide();
    }

    static void hideRegistration(){
        registrationStage.hide();
    }

    private static Stage authorizationStage(){
        Stage primaryStage = new Stage();

        try {
            Parent root = new FXMLLoader().load(authorization.getClass().getResourceAsStream("/fxml/authorization.fxml"));
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.setTitle("HHH");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return primaryStage;
    }

    private static Stage registrationStage(){
        Stage primaryStage = new Stage();

        try {
            Parent root = new FXMLLoader().load(authorization.getClass().getResourceAsStream("/fxml/registration.fxml"));
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.setTitle("HHH");

            primaryStage.setOnCloseRequest(event -> {
                WindowController.openAuthorization();
            });

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return primaryStage;
    }

    public static Stage getAuthorizationStage() {
        return authorizationStage;
    }

    public static Stage getRegistrationStage() {
        return registrationStage;
    }
}
