package su.jet.java.edu.loader.readers;

import su.jet.java.edu.loader.core.DataReader;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class XmlDataReader implements DataReader {

    @Override
    public UserData[] read() {
        return new UserData[] {new UserData(2, "Vasya xml")};
    }

}
