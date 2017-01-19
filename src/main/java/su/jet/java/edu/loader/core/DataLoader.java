package su.jet.java.edu.loader.core;

import java.io.IOException;
import java.util.Set;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class DataLoader {

    private final DataReader dataReader;
    private final DataWriter[] dataWriters;

    public DataLoader(DataWriter[] dataWriters, DataReader dataReaders) {
        this.dataReader = dataReaders;
        this.dataWriters = dataWriters;
    }

    public void doRead() {
        try {
            Set<UserData> users;
            while ((users = this.dataReader.read()) != null) {
                for (UserData user : users) {
                    writeUserDataToDataWriters(user);
                }
            }
            this.dataReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " " + ex.getCause());
        }
    }

    private void writeUserDataToDataWriters(UserData user) {
        for (DataWriter dataWriter : dataWriters) {
            if (user != null) {
                dataWriter.write(user);
            } else {
                System.out.println("users[counter] is null");
            }
        }
    }
}
