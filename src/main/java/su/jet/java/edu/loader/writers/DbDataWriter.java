package su.jet.java.edu.loader.writers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import su.jet.java.edu.loader.core.DataWriter;
import su.jet.java.edu.loader.dataclasses.UserData;

/**
 *
 * @author aleksandr-nevsky
 */
public class DbDataWriter extends DataWriter {

    @Override
    public void write(UserData userData) {
        //System.out.println("User id: " + userData.getId() + " name: " + userData.getName() + " write to DB");
        writeToDb(userData.getId(), userData.getName());
    }

    private void writeToDb(int id, String name) {
        try (Connection connection
                = DriverManager.getConnection("jdbc:derby://localhost:1527/example", "app", "app");) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT INTO USERS VALUES(?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("User id: " + id + " name: " + name + " write to DB");
        } catch (SQLException ex) {
            System.out.println("DB Fail " + ex.getMessage());
        }
    }

}
