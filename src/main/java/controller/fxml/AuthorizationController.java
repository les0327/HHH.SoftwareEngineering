package controller.fxml;

import controller.DataController;
import controller.WindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import model.entity.User;


/**
 * Created on 31.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class AuthorizationController {

    @FXML
    private Text actionTarget;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;


    @FXML
    protected void handleSignInButton(ActionEvent actionEvent) {
        DataController.setCurrentUser(DataController.getUserDAO().getByEmail(loginField.getText().trim()));
        User user = DataController.getCurrentUser();
        if (user != null)
            if (user.getPassword().equals(passwordField.getText())) {
                WindowController.hideAuthorization();
                clean();
                WindowController.openMainWindow();
            } else
                actionTarget.setText("Wrong password");
        else
            actionTarget.setText("No user found");
    }

    @FXML
    protected void handleCheckInButton(ActionEvent actionEvent) {
        WindowController.hideAuthorization();
        clean();
        WindowController.openRegistration();
    }

    @FXML
    protected void handleLoginKey(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                passwordField.requestFocus();
                break;
        }
    }

    @FXML
    protected void handlePasswordKey(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                handleSignInButton(new ActionEvent());
                break;
        }
    }

    private void clean(){
        actionTarget.setText(null);
        passwordField.setText(null);
        loginField.setText(null);
    }
}
