package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class JDBC implements Greeting {
    final String INSERT_USER_SQL = "insert into GreetUser (name, user_count) values(?, ?)";
    final String FIND_USER_SQL = "select user_count from GreetUser where name = ?";
    final String UPDATE_USER_SQL = "update GreetUser set user_count = user_count + 1 where name = ?";
    final String FIND_ALL_SQL = "select count(*) as name from GreetUser ";
    final String FIND_LIST_SQL = "select * from GreetUser ";
    final String DELETE_USER_SQL = "delete from GreetUser where name = ?";
    final String DELETE_ALL_SQL = "delete from GreetUser";

    Connection conn;
    PreparedStatement psCreateNewGreetings;
    PreparedStatement psGreetsCount;
    PreparedStatement psUpdateGreetsCount;
    PreparedStatement psAllUsers;
    PreparedStatement psListOfAll;
    PreparedStatement psDelUser;
    PreparedStatement psDelAll;

    public JDBC() {
        try {
            conn = DriverManager.
                        getConnection("jdbc:h2:./target/greet-in-java", "sa", "");
            psCreateNewGreetings = conn.prepareStatement(INSERT_USER_SQL);
            psGreetsCount = conn.prepareStatement(FIND_USER_SQL);
            psUpdateGreetsCount = conn.prepareStatement(UPDATE_USER_SQL);
            psAllUsers = conn.prepareStatement(FIND_ALL_SQL);
            psListOfAll = conn.prepareStatement(FIND_LIST_SQL);
            psDelUser = conn.prepareStatement(DELETE_USER_SQL);
            psDelAll = conn.prepareStatement(DELETE_ALL_SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void adding(String name) {
        Map<String, Integer> greetedNames = new HashMap<String, Integer>();
        try {
            psGreetsCount.setString(1, name);
            ResultSet rsName = psGreetsCount.executeQuery();

            if (!rsName.next()) {
                psCreateNewGreetings.setString(1, name);
                psCreateNewGreetings.setInt(2, 1);
                psCreateNewGreetings.execute();
            } else {
                int nameCount = rsName.getInt("user_count");
                psUpdateGreetsCount.setString(1, name);
                psUpdateGreetsCount.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String greeted(String name) {
        Map<String, Integer> greetedNames = new HashMap<String, Integer>();
        try {
            ResultSet resultSet = psListOfAll.executeQuery();
            while (resultSet.next()) {
                greetedNames.put(resultSet.getString("name"), resultSet.getInt("user_count"));
            }

            psGreetsCount.setString(1, name);
            ResultSet rs = psGreetsCount.executeQuery();

            if (rs.next()) {
                return name + " has been " + greetedNames.get(name).toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return greetedNames.toString();
    }

    @Override
    public String greet(String userName, String language) {
        try {
            adding(userName);
            return Language.valueOf(language).getMyLanguage() + userName;
        } catch (Exception e) {
            return Language.valueOf("setswana").getMyLanguage() + userName;
        }
    }

    @Override
    public String count() {
        Map<String, Integer> greetedNames = new HashMap<>();
        try {
            ResultSet resultSet = psListOfAll.executeQuery();
            while (resultSet.next()) {
                greetedNames.put(resultSet.getString("name"), resultSet.getInt("user_count"));
            }
            return "The number of greeted people greeted is: " + greetedNames.size();
        } catch (SQLException e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String clear(String userName) {
        try {
            psDelUser.setString(1, userName.toString());
            psDelUser.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userName + " has been cleared ";
    }

    public String clearAll() {
        try {
            psDelAll.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "All names are cleared";
    }

    public String help() {
        return " Valid commands are:\n\n" +
                "greet >> followed by the name and the language the user is to be greeted in,\n" +
                "greeted >> should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted followed by a username >> returns how many times that username have been greeted,\n" +
                "counter >> returns a count of how many unique users has been greeted,\n" +
                "clear >> deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear followed by a username >> delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit >> exits the application,\n" +
                "help >> shows a user an overview of all possible commands.";
    }
}