package su.jet.java.edu.loader.readers;

import java.util.Set;
import su.jet.java.edu.loader.core.DataReader;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class XmlDataReader implements DataReader {

    @Override
    public Set<UserData> read() {
        return null;
    }

    @Override
    public void close() {
        System.out.println("Close XML file");
    }

}
