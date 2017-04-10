package model.entity;

/**
 * Created on 05.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public enum ActionType {
    CREATE_ADVERT(0, "Create"),
    UPDATE_ADVERT(1, "Update"),
    DELETE_ADVERT(2, "Delete"),
    CONFIRM_ACTION(3, "Confirm");

    private int id;
    private String description;

    ActionType(int id, String description){
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
