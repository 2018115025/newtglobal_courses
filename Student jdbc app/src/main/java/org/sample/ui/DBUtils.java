package org.sample.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
    final static String URL;
    final static String username;
    final static String password;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex) {
            System.err.println("Fatal Error! Unable to start application");
            System.exit(1);
        }

//        ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");

//        URL = bundle.getString("url");
//        username = bundle.getString("username");
//        password = bundle.getString("password");
        URL="jdbc:postgresql://localhost:5432/demo";
        username="postgres";
        password="Dhanush@20";
    }

    static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }

    static void closeConnection(Connection conn) throws SQLException{
        if(conn != null)
            conn.close();
    }

    /**
     * checks if the resultset is empty or not
     * @param rs - The resultset to be checked for empty
     * @return - true of resultset is empty, false otherwise
     * @throws SQLException - if anything went wrong during this operation
     */
    static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
        return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
    }

}
