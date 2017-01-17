package su.jet.java.loader.test;

import su.jet.java.edu.loader.controller.DataLoader;
import su.jet.java.edu.loader.reader.CsvDataReader;
import su.jet.java.edu.loader.writer.DataWriter;

/**
 *
 * @author Nevsky <me@nevsky.cc>
 */
public class Test {

    public static void main(String[] args) {

        DataLoader dynamicDataLoader = new DataLoader(
                new DataWriter[]{new TestDbDataWriter(), new TestLdapDataWriter()},
                new CsvDataReader(2, "C:\\NetBeansProjects\\java-ee-4-beginners\\data.csv")
        );
        dynamicDataLoader.doRead();

    }

}
