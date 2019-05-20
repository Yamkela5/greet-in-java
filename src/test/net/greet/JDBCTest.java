package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JDBCTest {
    final String GREET_DATABASE_URL = "jdbc:h2:./target/JBDC";

    public Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        return conn;
    }


    @Test
    public void loadDriver() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase() {

        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    void shouldDisplayNames() {
        JDBC jdbc = new JDBC();

        assertEquals("{}", jdbc.greeted("Yamkela"));
    }
@Test
    void shouldClear(){
        JDBC jdbc = new JDBC();
    assertEquals("Yamkela has been cleared ", jdbc.clear("Yamkela"));
}
@Test
    void shoulClearAllUsers(){
        JDBC jdbc = new JDBC();
    assertEquals("All names are cleared",jdbc.clearAll());

}
@Test
    void shouldReturnNumberOfGreetedPeople(){
        JDBC jdbc = new JDBC();
    assertEquals("The number of greeted people greeted is: 0", jdbc.count());
}
}
