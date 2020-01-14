package co.arum.board.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public DAO() {
		getConfiguration();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getConfiguration() {
		Properties proper = new Properties();
		try {
			Reader reader = new FileReader("config/db.properties");
			proper.load(reader);
			driver = proper.getProperty("driver");
			url = proper.getProperty("url");
			user = proper.getProperty("user");
			password = proper.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
