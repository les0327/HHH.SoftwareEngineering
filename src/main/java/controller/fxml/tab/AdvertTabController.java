package controller.fxml.tab;

import controller.DataController;
import controller.WindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TableView;
import model.entity.Action;
import model.entity.ActionType;
import model.entity.Advert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created on 08.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class AdvertTabController {

    @FXML
    private TableView<Advert> table;

    @FXML
    private CheckMenuItem showMenuItem;

    @FXML
    protected void initialize(){
        update();
    }

    @FXML
    protected void handleUpdateButton(ActionEvent actionEvent) {
        update();
    }

    @FXML
    protected void handleNewAdvertButton(ActionEvent actionEvent) {
        WindowController.openNewAdvertWindow();
    }

    @FXML
    protected void handleDeleteMenuItem(ActionEvent actionEvent) {
        Advert advert = table.getSelectionModel().getSelectedItem();
        Action action = DataController.getActionDAO().getByAdvert(advert, ActionType.CREATE_ADVERT);

        if (action.getAuthor().equals(DataController.getCurrentUser())){

            Action deleteAction = new Action();
            deleteAction.setType(ActionType.DELETE_ADVERT);
            deleteAction.setDate(new Date());
            deleteAction.setAuthor(DataController.getCurrentUser());
            deleteAction.setAdvert(advert);
            advert.setValid(false);
            DataController.getActionDAO().save(deleteAction);
            DataController.getAdvertDAO().update(advert);
            update();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("You can not delete this advert");
            alert.setContentText("You are not author of this advert");
            alert.show();
        }
    }

    @FXML
    protected void handleUpdateMenuItem(ActionEvent actionEvent) {
        update();
    }

    @FXML
    protected void handleShowMenuItem(ActionEvent actionEvent) {
        if (showMenuItem.isSelected()) {
            List<Advert> list = new ArrayList<>();
            DataController.getActionDAO().getUserActions(DataController.getCurrentUser()).forEach( action -> {
                if (action.getAdvert().isValid())
                    list.add(action.getAdvert());
            });
            table.getItems().clear();
            table.getItems().addAll(list);
        } else {
            update();
        }
    }

    private void update(){
        table.getItems().clear();
        DataController.updateAdverts();
        table.getItems().addAll(DataController.getAdverts());
    }
}
