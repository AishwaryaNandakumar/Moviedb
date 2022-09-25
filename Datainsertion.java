package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Datainsertion {

   
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/Aishwarya.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    public void insert(String Movie_Name,String Lead_Actor,String Lead_Actress,String Director_name, Integer Year_Of_Release) {
        String sql = "INSERT INTO Movies(Movie_Name,Lead_Actor,Lead_Actress,Director_name,Year_Of_Release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            	pstmt.setString(1, Movie_Name);
		pstmt.setString(2, Lead_Actor);
		pstmt.setString(3, Lead_Actress);
		pstmt.setString(4, Director_name);
            	pstmt.setInt(5, Year_Of_Release);
            	pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Datainsertion data = new Datainsertion();
        // insert three new rows
        data.insert("ABC","a","b","c", 2001);
        data.insert("XYZ","x","y","z", 2001);
        data.insert("PQR","p","q","r", 2002);
        data.insert("EFG","e","f","g", 2003);
	data.insert("IJK","i","j","k", 2004);
    }

}