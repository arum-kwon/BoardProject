package co.arum.board.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import co.arum.board.dto.BoardDto;

public abstract class BoardService {
	public Connection conn;
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private void configProperties() {
		Properties properties = new Properties();
		Reader reader;
		try {
			reader = new FileReader("config/db.properties");
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	public BoardService() {
		try {
			configProperties();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public abstract List<BoardDto> allSelect();
	public abstract BoardDto select(BoardDto dto);
	public abstract int update(BoardDto dto);
	public abstract int insert(BoardDto dto);
	public abstract int delete(BoardDto dto);
	public abstract void close();
	public abstract List<BoardDto> search(String keyword);
}
