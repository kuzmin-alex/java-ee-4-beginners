package su.jet.java.edu.loader;

import su.jet.java.edu.loader.interfaces.DataWriter;
import su.jet.java.edu.loader.impl.CsvDataReader;
import su.jet.java.edu.loader.impl.DbDataWriter;
import su.jet.java.edu.loader.impl.LdapDataWriter;

/**
 *
 * @author aleksandr-nevsky
 */
public class Run {
    
    public static void main(String[] args) {

        DataLoader dynamicDataLoader = new DataLoader(
                new DataWriter[]{new DbDataWriter(), new LdapDataWriter()},
                new CsvDataReader(2)
        );

        dynamicDataLoader.doRead();

    }

}
