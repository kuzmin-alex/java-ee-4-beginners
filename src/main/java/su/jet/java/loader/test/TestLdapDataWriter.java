package su.jet.java.loader.test;

import su.jet.java.edu.loader.writer.DataWriter;
import su.jet.java.edu.loader.controller.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class TestLdapDataWriter implements DataWriter {

    @Override
    public void write(UserData user) {
        System.out.println("User id: " + user.getId() + " name: " + user.getName() + " write to LDAP");
    }
}
