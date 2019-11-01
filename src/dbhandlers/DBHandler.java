package dbhandlers;

// Import Java.sql

import oggetti.Persona;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DBHandler {
    // Create a connection variable and set it to null

    Connection conn = null;

    public DBHandler() {
        // Provide a try and catch exception
        try {
            // Connect to mysql library
            Class.forName("com.mysql.jdbc.Driver");
            // jdbc:mysql://hostname:port/databasename, server username, server password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_list", "root", "");

        } catch (Exception ex) {
            // If connection fail
            System.out.println("Erro: " + ex);

        }
    }

    public static Connection getConnection() {

        // Provide a try and catch exception
        try {
            // Connect to mysql library
            Class.forName("com.mysql.jdbc.Driver");
            // jdbc:mysql://hostname:port/databasename, server username, server password
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_list", "root", "");
            return conn;

        } catch (Exception ex) {
            // If connection fail
            System.out.println("Erro: " + ex);
            return null;
        }

    }

  public  void loadRecordsToModel(DefaultTableModel model) {
        String sql = "SELECT * FROM tbl_list";

        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();

            PreparedStatement stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            // Define jtable
            /*
            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
            for (int col = 1; col <= colCount; col++) {
                TableColumn column1 = jtable.getTableHeader().getColumnModel().getColumn(col-1);

                column1.setHeaderValue(meta.getColumnName(col).toString().toUpperCase());

            
            }
            jtable.getTableHeader().repaint();
             */

            while (rs.next()) {
                // set value to jtable
                String id = rs.getString("ID");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String age = rs.getString("age");
                Object[] row = {id, fname, lname, age};
                // Insert value to jtable row and column
                model.addRow(row);

            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public  boolean insPersona(Persona p) {
        boolean ok = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // String sql = "INSERT INTO tbl_list(fname, lname, age) VALUES('"+fname+"','"+lname+"','"+age+"')";
        String sql = "INSERT INTO tbl_list(fname, lname, age) VALUES(?,?,?)";
        try {
            // set stmt to create statement
            stmt = conn.prepareStatement(sql);
            stmt.setInt(3, p.getAge());
            stmt.setString(2, p.getLastname());
            stmt.setString(1, p.getFirstname());

// executeUpdate() function runs condition like InsertRecord, UpdateRecord, delete, drop etc
            // executeUpdate return 1 if true 0 if false
            if (stmt.executeUpdate() == 1) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return ok;
    }

}
