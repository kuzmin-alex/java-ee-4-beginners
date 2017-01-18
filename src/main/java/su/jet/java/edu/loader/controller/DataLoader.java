package su.jet.java.edu.loader.controller;

import su.jet.java.edu.loader.reader.DataReader;
import su.jet.java.edu.loader.writer.DataWriter;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class DataLoader {

    private final DataReader dataReader;
    private final DataWriter[] dataWriters;

    public DataLoader(DataWriter[] dataWriters, DataReader dataReaders) {
        this.dataReader = dataReaders;
        this.dataWriters = dataWriters;
    }

    public void load() {
        UserData[] users;
        while ((users = this.dataReader.read())[0] != null) {
            for (UserData user : users) {
                if (user != null) {
                    for (DataWriter dataWriter : dataWriters) {

                        dataWriter.write(user);

                    }
                }
            }
        }
    }

}
