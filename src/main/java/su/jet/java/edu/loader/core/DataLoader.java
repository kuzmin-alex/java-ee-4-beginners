package su.jet.java.edu.loader.core;

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
        UserData[] users;
        while ((users = this.dataReader.read())[0] != null) {
            for (UserData user : users) {
                writeUserDataToDataWriters(user);
            }
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
