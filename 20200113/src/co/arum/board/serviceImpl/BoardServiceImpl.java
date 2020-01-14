package co.arum.board.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import co.arum.board.dto.BoardDto;
import co.arum.board.service.DAO;
import co.arum.board.service.Service;

public class BoardServiceImpl extends DAO implements Service {

	private final String SELECT= "SELECT * FROM BOARD WHERE BOARD_ID = ?";
	@Override
	public <E> List<E> allSelect() {
		return null;
	}

	@Override
	public BoardDto select(BoardDto dto) {
		BoardDto bDto = new BoardDto();
		
		try {
			psmt =conn.prepareStatement(SELECT);	
			psmt.setInt(1, dto.getBoard_id());
			rs = psmt.executeQuery();
			if(rs.next()) {
				bDto.setBoard_id(rs.getInt("board_id"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setWriteDate(rs.getDate("writedate"));
				bDto.setTitle(rs.getString("title"));
				bDto.setSubject(rs.getString("subject"));
				bDto.setHit(rs.getInt("hit"));
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return bDto;
	}

	@Override
	public <E> int update(E e) {
		return 0;
	}

	@Override
	public <E> int insert(E e) {
		return 0;
	}

	@Override
	public <E> int delete(E e) {
		return 0;
	}

}
