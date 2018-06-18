package rieqyns13;

import java.sql.*;


public class Koneksi {
	 static Connection con=null;
	    public static Connection getConnection()
	    {
	        if (con != null) return con;
	        // get db, user, pass from settings file
	        return getConnection("test", "root", "");
	    }

	    private static Connection getConnection(String db_name,String user_name,String password)
	    {
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con=DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+user_name+"&password="+password);
	            System.out.println("Koneksi sukses");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	        return con;        
	    }
}
