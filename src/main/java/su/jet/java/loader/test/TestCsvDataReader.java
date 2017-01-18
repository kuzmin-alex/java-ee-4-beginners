package su.jet.java.loader.test;

import su.jet.java.edu.loader.reader.*;
import su.jet.java.edu.loader.controller.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class TestCsvDataReader implements DataReader {
//int countOfUsers;
//       public TestCsvDataReader(int countOfUsers) {
//           this.countOfUsers=countOfUsers;
//     }

    @Override
    public UserData[] read() {
        UserData[] users = new UserData[2];
        users[0] = (new UserData(1, "Vasya1 csv"));
        users[1] = (new UserData(2, "Vasya2 csv"));
        return users;
    }

}
