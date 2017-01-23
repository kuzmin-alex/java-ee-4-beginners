package su.jet.java.edu.loader.readers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import su.jet.java.edu.loader.core.DataReader;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class CsvDataReader implements DataReader {

    private BufferedReader bufferedReader;
    private int batchSize;
    private File file = new File("/tmp/data.csv");

    public CsvDataReader() {
        this(1);

    }

    public CsvDataReader(int batchSize) {
        this.batchSize = batchSize;
    }

    public CsvDataReader(int batchSize, File csvFile) {
        this.batchSize = batchSize;
        this.file = csvFile;
    }

    private void openConnectToBufferedReader() throws IOException {
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(file))));
        } catch (FileNotFoundException e) {
            throw new IOException("CSV file is missing", e);
        }
    }

    @Override
    public void close() {
        closeBufferReaderConnection();
    }

    private void closeBufferReaderConnection() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
                bufferedReader = null;
            } else {
                System.out.println("CSV bufferedReader already closed");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Открывает BufferedReader. Нужно закрывать методом
     * closeBufferReaderConnection().
     *
     * @return userDatas
     * @throws java.io.IOException
     */
    @Override
    public Set<UserData> read() throws IOException {
        if (bufferedReader == null) {
            openConnectToBufferedReader();
        }
        Set<UserData> userDatas = new HashSet<>();

        for (int counter = 0; counter < batchSize; counter++) {
            UserData ud;

            if ((ud = getUserDataInstance()) != null) {
                userDatas.add(ud);
            }

        }
        return (userDatas.isEmpty()) ? null  : userDatas;

    }

    private UserData getUserDataInstance() {
        try {
            String currentLine;
            UserData userData;
            if ((currentLine = bufferedReader.readLine()) != null) {
                String[] rowData = currentLine.split(",");
                if (rowData.length != 2) {
                    System.out.println("Bad data in line");
                    return null;
                }
                userData = new UserData(Integer.parseInt(rowData[0]), rowData[1]);
                return userData;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
        return null;
    }

}
