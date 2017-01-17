package su.jet.java.edu.loader.reader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import su.jet.java.edu.loader.controller.UserData;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class CsvDataReader implements DataReader {

    private BufferedReader bufferedReader;
    private final int batchSize;
    private final String filePath;

//    public CsvDataReader() {
//    this(1);
//     }
    public CsvDataReader(int batchSize, String filePath) {
        this.batchSize = batchSize;
        this.filePath = filePath;
    }

    private void connectToBufferedReader() {
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public UserData[] read() {
        if (bufferedReader == null) {
            connectToBufferedReader();
        }

        UserData[] users = new UserData[batchSize];
        for (int counter = 0; counter < batchSize; counter++) {
            UserData user;

            if ((user = getUserDataInstance()) != null) {
                users[counter] = user;
            }

        }

        return users;
        // return (users.length != 0) ? users : null;
    }

    private UserData getUserDataInstance() {
        try {
            String currentLine;
            UserData userData = null;
            if ((currentLine = bufferedReader.readLine()) != null) {
                String[] rowData = currentLine.split(",");
                userData = new UserData(Integer.parseInt(rowData[0]), rowData[1]);
                return userData;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
