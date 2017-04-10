package controller.fxml.tab;

import controller.DataController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entity.Action;

/**
 * Created on 10.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class HistoryTabController {

    @FXML
    protected TableView table;

    @FXML
    protected TableColumn<Action, String> advertColumn;

    @FXML
    protected void update(){
        table.getItems().clear();
        DataController.updateUserActions();
        table.getItems().addAll(DataController.getUserActions());
    }
}
