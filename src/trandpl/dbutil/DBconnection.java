
package trandpl.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBconnection {
    final static String MYSQL_DB_URL="jdbc:mysql://database-1.c1x7edzyuaa0.ap-south-1.rds.amazonaws.com/sys";
    final static String MYSQL_DB_USER_NAME="TrAndPl";//Aadarsh Jain
    final static String MYSQL_DB_PASS="Aadarsh123";
    public static Connection conn;
    static{
        try{
//            Class.forName("oracle.jdbc.OracleDriver");
//            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-D4PMKOCH:1521/XE", "tnp","project");

              Class.forName("com.mysql.cj.jdbc.Driver");
              conn=DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER_NAME,MYSQL_DB_PASS);
            JOptionPane.showMessageDialog(null, "Connected successfully to the DB");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error in Driver loading: "+ex.getMessage());
            ex.printStackTrace();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in opening the connection to DB: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "Disconnected successfully to the DB");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in closing the connection to DB: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
