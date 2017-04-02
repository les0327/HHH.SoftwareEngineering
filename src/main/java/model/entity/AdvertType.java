package model.entity;

/**
 * Created on 05.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public enum AdvertType {
    FIND_PASSENGER(0, "Find passenger"),
    FIND_CAR(1, "Find car");

    int id;
    String description;

    AdvertType(int id, String description){
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
