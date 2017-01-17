package su.jet.java.edu.loader.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.jet.java.edu.loader.interfaces.DataReader;
import su.jet.java.edu.loader.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class CsvDataReader implements DataReader {

    BufferedReader bufferedReader;
    int batchSize = 1;

    public CsvDataReader() {

    }

    public CsvDataReader(int batchSize) {
        this.batchSize = batchSize;
    }

    private void connectToBufferedReader() {
        try {
            File file = new File("/tmp/data.csv");
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
//        try {
//            String currentLine;
//            UserData userData = null;
//            if ((currentLine = bufferedReader.readLine()) != null) {
//                String[] rowData = currentLine.split(",");
//                userData = new UserData(Integer.parseInt(rowData[0]), rowData[1]);
//                return userData;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        UserData[] userDatas = new UserData[batchSize];
        for (int counter = 0; counter < batchSize; counter++) {
            UserData ud;

            if ((ud = getUserDataInstance()) != null) {
                userDatas[counter] = ud;
            }

        }

        //return userDatas;
        return (userDatas.length != 0) ? userDatas : null;
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
            System.out.println(e);
        }
        return null;
    }

}
