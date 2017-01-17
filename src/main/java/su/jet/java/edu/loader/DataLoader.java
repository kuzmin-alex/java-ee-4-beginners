package su.jet.java.edu.loader;

import su.jet.java.edu.loader.interfaces.DataReader;
import su.jet.java.edu.loader.interfaces.DataWriter;

/**
 *
 * @author aleksandr-nevsky
 */
public class DataLoader {

    private DataReader dataReader;
    private DataWriter[] dataWriters;

    public DataLoader(DataWriter[] dataWriters, DataReader dataReaders) {
        this.dataReader = dataReaders;
        this.dataWriters = dataWriters;
    }

//    public void doRead() {
//        UserData user = this.dataReader.read();
//        for (DataWriter dataWriter : dataWriters) {
//            dataWriter.write(user);
//        }
//    }
    public void doRead() {
        UserData[] users;
        while ((users = this.dataReader.read())[0] != null) {
//            for (int counter = 0; counter < users.length; counter++) {
//                System.out.println(users.length);
//                for (DataWriter dataWriter : dataWriters) {
//                    if (users[counter] != null) {
//                        dataWriter.write(users[counter]);
//                    } else {
//                        System.out.println("users[counter] is null");
//                    }
//                }
//            }

            for (int counter = 0; counter < users.length; counter++) {
                System.out.println(users.length);
                for (DataWriter dataWriter : dataWriters) {
                    if (users[counter] != null) {
                        dataWriter.write(users[counter]);
                    } else {
                        System.out.println("users[counter] is null");
                    }
                }
            }


        }

    }

}
