package co.arum.board.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.arum.board.dto.BoardDto;
import co.arum.board.service.BoardService;

public class BoardServiceImpl extends BoardService {
	PreparedStatement pmst;
	ResultSet rs;
	
	private String SELECT_ALL = "SELECT * FROM BOARD";
	private String SELECT = "SELECT * FROM BOARD WHERE BOARD_ID = ?";
	private String INSERT = "INSERT INTO BOARD VALUES (BOARD_ID_SEQ.NEXTVAL, ?, ?, ?)";
	private String UPDATE = "UPDATE BOARD SET SUBJECT = ? WHERE BOARD_ID = ?";
	private String DELETE = "DELETE FROM BOARD WHERE BOARD_ID = ?";
	
	@Override
	public List<BoardDto> allSelect() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			pmst = conn.prepareStatement(SELECT_ALL);
			rs = pmst.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setWritedate(rs.getDate("writedate"));
				dto.setTitle(rs.getString("title"));
				dto.setSubject(rs.getString("subject"));
				dto.setHit(rs.getInt("hit"));
				list.add(dto);
			}
			if(rs != null) {
				rs.close();
			}
			if(pmst != null) {
				pmst.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto select(BoardDto dto) {
		BoardDto bDto = new BoardDto();
		try {
			pmst = conn.prepareStatement(SELECT);
			pmst.setInt(1, dto.getBoard_id());
			rs = pmst.executeQuery();
			if(rs.next()) {
				bDto.setBoard_id(rs.getInt("board_id"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setWritedate(rs.getDate("writedate"));
				bDto.setTitle(rs.getString("title"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bDto;
	}

	@Override
	public int update(BoardDto dto) {
		int n = 0;
		try {
			pmst = conn.prepareStatement(UPDATE);
			pmst.setString(1, dto.getSubject());
			pmst.setInt(2, dto.getBoard_id());
			n = pmst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int insert(BoardDto dto) {
		int n = 0;
		try {
			pmst = conn.prepareStatement(INSERT);
			pmst.setString(1, dto.getWriter());
			pmst.setString(2, dto.getTitle());
			pmst.setString(3, dto.getSubject());
			n = pmst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int delete(BoardDto dto) {
		int n = 0;
		try {
			pmst = conn.prepareStatement(DELETE);
			pmst.setInt(1, dto.getBoard_id());
			n = pmst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
