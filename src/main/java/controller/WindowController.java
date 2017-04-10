package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import view.Authorization;

import java.io.IOException;

/**
 * Created on 02.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class WindowController {

    private static Authorization authorization      = new Authorization();

    private @Getter static Stage authorizationStage = authorizationStage();
    private @Getter static Stage registrationStage  = registrationStage();
    private @Getter static Stage mainWindowStage    = mainWindowStage();
    private @Getter static Stage newAdvertStage     = newAdvertStage();

    public static void openAuthorization(){
        authorizationStage.show();
    }

    public static void openRegistration(){
        registrationStage.show();
    }

    public static void openMainWindow(){
        mainWindowStage.show();
    }

    public static void openNewAdvertWindow(){
        newAdvertStage.show();
    }

    public static void hideAuthorization(){
        authorizationStage.hide();
    }

    public static void hideRegistration(){
        registrationStage.hide();
    }

    public static void hideMainWindow(){
        mainWindowStage.hide();
    }

    public static void hideNewAdvertWindow(){
        newAdvertStage.hide();
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
                ((Stage) primaryStage.getOwner()).show();
                root.getChildrenUnmodifiable().forEach(child -> {
                    if (child instanceof TextField)
                        ((TextField) child).setText(null);
                });
            });
            primaryStage.initOwner(authorizationStage);
            primaryStage.initModality(Modality.APPLICATION_MODAL);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return primaryStage;
    }

    private static Stage mainWindowStage(){
        Stage primaryStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(authorization.getClass().getResource("/fxml/main_window.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("HHH");

            primaryStage.setOnCloseRequest(event -> ((Stage) primaryStage.getOwner()).show());
            primaryStage.initOwner(authorizationStage);
            primaryStage.initModality(Modality.APPLICATION_MODAL);

        } catch (IOException e){
            e.printStackTrace();
        }

        return primaryStage;
    }

    private static Stage newAdvertStage(){
        Stage primaryStage = new Stage();

        try {
            Parent root = new FXMLLoader().load(authorization.getClass().getResourceAsStream("/fxml/new_advert.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("HHH");

            primaryStage.initOwner(mainWindowStage);
            primaryStage.initModality(Modality.APPLICATION_MODAL);

            primaryStage.setOnCloseRequest(event -> root.getChildrenUnmodifiable().forEach(child -> {
                if (child instanceof TextField)
                    ((TextField) child).setText(null);
                else if (child instanceof TextArea)
                    ((TextArea) child).setText(null);
                else if (child instanceof DatePicker)
                    ((DatePicker) child).setValue(null);
                else if (child instanceof ComboBox)
                    ((ComboBox) child).setValue(null);
            }));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return primaryStage;
    }

}
