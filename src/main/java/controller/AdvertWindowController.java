package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.entity.Advert;


/**
 * Created on 08.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class AdvertWindowController {
    @FXML
    private TableView<Advert> table;

    @FXML
    protected void initialize(){
        DataController.updateAdverts();
        table.getItems().addAll(DataController.getAdverts());
    }

    public void handleUpdateButton(ActionEvent actionEvent) {
        table.getItems().clear();
        DataController.updateAdverts();
        table.getItems().addAll(DataController.getAdverts());
    }

    public void handleNewAdvertButton(ActionEvent actionEvent) {

    }
}
