package su.jet.java.edu.loader.writer;

import su.jet.java.edu.loader.controller.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class DbDataWriter implements DataWriter {

    @Override
    public void write(UserData user) {
        System.out.println("User id: " + user.getId() + " name: " + user.getName() + " write to DB");

    }

}
