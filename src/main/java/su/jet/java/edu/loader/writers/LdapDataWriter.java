package su.jet.java.edu.loader.writers;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import su.jet.java.edu.loader.core.DataWriter;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class LdapDataWriter extends DataWriter {

    @Override
    public void write(UserData userData) {
        writeToLdap(userData);
    }

    private void writeToLdap(UserData userData) {
        DirContext initialDirContext = null;

        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.put(Context.PROVIDER_URL, "ldap://localhost:10389/ou=system");

            props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_PRINCIPAL, "uid=admin, ou=system");
            props.put(Context.SECURITY_CREDENTIALS, "secret");

            props.put("com.sun.jndi.ldap.connect.timeout", "5000");
            props.put("com.sun.jndi.ldap.connect.pool", "true");
            props.put("com.sun.jndi.ldap.connect.pool.debug", "fine");

            //Dir Examples
            initialDirContext = new InitialDirContext(props);
            final DirContext usersContext = (DirContext) initialDirContext.lookup("ou=users");
            Attributes personAttributes = new BasicAttributes();
            BasicAttribute personBasicAttribute = new BasicAttribute("objectclass");
            personBasicAttribute.add("top");
            personBasicAttribute.add("person"); //http://www.zytrax.com/books/ldap/ape/core-schema.html#person
            personBasicAttribute.add("uidObject"); //http://www.zytrax.com/books/ldap/ape/core-schema.html#uidObject
            personAttributes.put(personBasicAttribute);
            personAttributes.put("sn", userData.getName());
            personAttributes.put("uid", String.valueOf(userData.getId()));
            
            final DirContext adminsContext = (DirContext) usersContext.lookup("ou=admins");
            adminsContext.bind("cn=" +  userData.getName(), userData, personAttributes);
            System.out.println("User id: " + userData.getId() + " name: " + userData.getName() + " write to LDAP");

        } catch (NamingException ex) {
            System.out.println("LDAP Error: " + ex.getMessage());
        }
    }
}
