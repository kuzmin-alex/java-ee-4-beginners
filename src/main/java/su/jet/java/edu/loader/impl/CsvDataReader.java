package su.jet.java.edu.loader.impl;

import java.util.ArrayList;
import su.jet.java.edu.loader.interfaces.DataReader;
import su.jet.java.edu.loader.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class CsvDataReader implements DataReader {

   // private ArrayList <UserData> users = new ArrayList(); //??????
    
    @Override
    public ArrayList<UserData> read() {
        users.add(new UserData(1, "Vasya1 csv"));
        users.add(new UserData(2, "Vasya2 csv"));
        return users;
    }

}
