package su.jet.java.edu.loader.tests;

import su.jet.java.edu.loader.core.DataWriter;
import su.jet.java.edu.loader.core.DataLoader;
import su.jet.java.edu.loader.readers.CsvDataReader;
import su.jet.java.edu.loader.writers.DbDataWriter;
import su.jet.java.edu.loader.writers.LdapDataWriter;

/**
 *
 * @author aleksandr-nevsky
 */
public class RunMainTest {
    
    public static void main(String[] args) {

        DataLoader dynamicDataLoader = new DataLoader(
                new DataWriter[]{new DbDataWriter(), new LdapDataWriter()},
                new CsvDataReader(2)
        );

        dynamicDataLoader.doRead();
//        dynamicDataLoader.doRead();
    }

}
