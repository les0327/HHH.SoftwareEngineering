package controller.fxml;

import controller.DataController;
import controller.WindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.entity.User;

/**
 * Created on 01.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class RegistrationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleSignInButton(ActionEvent actionEvent) {
        User user = new User();
        user.setName(nameField.getText().trim());
        user.setEmail(loginField.getText().trim());
        user.setPassword(passwordField.getText().trim());

        DataController.getUserDAO().save(user);

        WindowController.hideRegistration();
        clean();
        WindowController.openAuthorization();
    }

    private void clean(){
        nameField.setText(null);
        loginField.setText(null);
        passwordField.setText(null);
    }
}
