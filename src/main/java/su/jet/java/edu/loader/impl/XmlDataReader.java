package su.jet.java.edu.loader.impl;

import su.jet.java.edu.loader.interfaces.DataReader;
import su.jet.java.edu.loader.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class XmlDataReader implements DataReader {

    @Override
    public UserData read() {
        return new UserData(2, "Vasya xml");
    }

}
