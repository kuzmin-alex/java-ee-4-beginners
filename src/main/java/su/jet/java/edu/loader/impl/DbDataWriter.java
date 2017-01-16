package su.jet.java.edu.loader.impl;

import java.util.ArrayList;
import su.jet.java.edu.loader.interfaces.DataWriter;
import su.jet.java.edu.loader.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class DbDataWriter implements DataWriter {

    public void write(ArrayList<UserData> userData) {
        for (UserData user: userData) {
        System.out.println("User id: " + user.getId() + " name: " + user.getName() + " write to DB");
        }
    }

}
