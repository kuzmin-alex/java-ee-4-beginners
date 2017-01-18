package su.jet.java.edu.loader.writers;

import su.jet.java.edu.loader.core.DataWriter;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class DbDataWriter extends DataWriter {


    @Override
    public void write(UserData userData) {
        System.out.println("User id: " + userData.getId()+ " name: " + userData.getName()+ " write to DB");
    }

}
