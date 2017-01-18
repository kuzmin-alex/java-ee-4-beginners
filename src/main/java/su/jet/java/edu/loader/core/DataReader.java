package su.jet.java.edu.loader.core;

import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public interface DataReader {

    UserData[] read();
    public void close();
}
