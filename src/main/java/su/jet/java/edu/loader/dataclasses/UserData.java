package su.jet.java.edu.loader.dataclasses;

import java.io.Serializable;

/**
 *
 * @author aleksandr-nevsky
 */
public class UserData implements Serializable {

    private int id;
    private String name;

    public UserData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserData() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
