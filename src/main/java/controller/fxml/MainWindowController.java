package controller.fxml;

import controller.DataController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created on 10.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class MainWindowController {

    @FXML
    protected Tab profileTab;

    @FXML
    protected Tab historyTab;

    public void selectProfileTab(Event event) {
        if (profileTab.isSelected()){
            ((Parent) profileTab.getContent()).getChildrenUnmodifiable().forEach(child -> {
                if (child instanceof TextField){
                    switch (child.getId()){
                        case "nameField":
                            ((TextField) child).setText(DataController.getCurrentUser().getName());
                            break;
                        case "loginField":
                            ((TextField) child).setText(DataController.getCurrentUser().getName());
                            break;
                        case "passwordField":
                            ((TextField) child).setText(DataController.getCurrentUser().getName());
                            break;
                    }
                }
            });
        }
    }

    public void selectHistoryTab(Event event) {
        if (historyTab.isSelected()){
            ((Parent) historyTab.getContent()).getChildrenUnmodifiable().forEach(child -> {
                if (child instanceof TableView){
                    ((TableView) child).getItems().clear();
                    DataController.updateUserActions();
                    ((TableView) child).getItems().addAll(DataController.getUserActions());
                }
            });
        }
    }
}
