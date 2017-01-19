package su.jet.java.edu.loader.core;

import java.io.IOException;
import java.util.Set;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public interface DataReader {

    Set<UserData> read() throws IOException;
    public void close();
}
