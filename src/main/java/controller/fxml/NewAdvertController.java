package controller.fxml;

import controller.DataController;
import controller.WindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.entity.Action;
import model.entity.ActionType;
import model.entity.Advert;
import model.entity.AdvertType;

import java.util.Date;

/**
 * Created on 09.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class NewAdvertController {
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private ComboBox typeBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField seatField;

    @FXML
    protected void handleNameField(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ENTER:
                descriptionArea.requestFocus();
                break;
        }
    }

    @FXML
    protected void handleDescriptionArea(KeyEvent keyEvent){
        switch (keyEvent.getCode()){
            case ENTER:
                seatField.requestFocus();
                break;
        }
    }

    @FXML
    protected void handleCreateButton(ActionEvent actionEvent) {
        Advert advert = new Advert();
        advert.setName(nameField.getText().trim());
        advert.setDescription(descriptionArea.getText().trim());
        advert.setCreation(new Date());
        advert.setEnd(java.sql.Date.valueOf(datePicker.getValue()));
        advert.setType((AdvertType) typeBox.getValue());
        advert.setSeatNumber(Integer.parseInt(seatField.getText().trim()));
        advert.setValid(true);

        Action action = new Action();
        action.setAuthor(DataController.getCurrentUser());
        action.setAdvert(advert);
        action.setDate(advert.getCreation());
        action.setType(ActionType.CREATE_ADVERT);

        DataController.getAdvertDAO().save(advert);
        DataController.getActionDAO().save(action);
        DataController.updateAdverts();
        clean();
        WindowController.hideNewAdvertWindow();
    }

    private void clean(){
        nameField.setText(null);
        descriptionArea.setText(null);
        seatField.setText(null);
        datePicker.setValue(null);
        typeBox.setValue(null);
    }
}
