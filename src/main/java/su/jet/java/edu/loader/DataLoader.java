package su.jet.java.edu.loader;

import su.jet.java.edu.loader.interfaces.DataReader;
import su.jet.java.edu.loader.interfaces.DataWriter;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class DataLoader {

    private DataReader dataReader;
    private DataWriter[] dataWriters;

    public DataLoader(DataWriter[] dataWriters, DataReader dataReaders) {
        this.dataReader = dataReaders;
        this.dataWriters = dataWriters;
    }

    public void doRead() {
        UserData user = this.dataReader.read();
        for (DataWriter dataWriter : dataWriters) {
            dataWriter.write(user);
        }
    }

}
