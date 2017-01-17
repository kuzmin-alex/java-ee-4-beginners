package su.jet.java.edu.loader.impl;

import su.jet.java.edu.loader.interfaces.DataWriter;
import su.jet.java.edu.loader.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class LdapDataWriter extends DataWriter{

    @Override
    public void write(UserData userData) {
        System.out.println("User id: " + userData.getId()+ " name: " + userData.getName()+ " write to LDAP");
    }

}
