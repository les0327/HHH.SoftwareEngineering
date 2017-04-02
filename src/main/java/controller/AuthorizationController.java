package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DAO.UserDAO;
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

    private UserDAO userDAO = new UserDAO();

    @FXML
    protected void handleSignInButton(ActionEvent actionEvent) {
        User user = userDAO.getByEmail(loginField.getText().trim());

        if (user != null)
            if (user.getPassword().equals(passwordField.getText()))
                actionTarget.setText("Success");
            else
                actionTarget.setText("Wrong password");
        else
            actionTarget.setText("No user found");
    }

    @FXML
    protected void handleCheckInButton(ActionEvent actionEvent) {
        WindowController.hideAuthorization();
        WindowController.openRegistration();
    }
}
