package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConection {

	
		public static final String JDBC_URL = "jdbc:mysql://localhost:3306/tiendario";
		 public static Connection instance = null;
		
		 private DBConection() {

		    }

		    public static Connection getConnection() throws SQLException {

		        if(instance == null) {
		            //opcional
		            Properties props = new Properties();
		            props.put("user", "root");
		            props.put("password", "123456789");
		            props.put("charset", "UTF-8");


		            instance = DriverManager.getConnection(JDBC_URL, props);
		        }
		        return instance;

		    }

		public PreparedStatement prepareStatement1(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public PreparedStatement prepareStatement(String string) {
			// TODO Auto-generated method stub
			return null;
		}

	
	
	
}
