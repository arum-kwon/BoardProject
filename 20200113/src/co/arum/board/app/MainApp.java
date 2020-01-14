package co.arum.board.app;

import co.arum.board.dto.BoardDto;
import co.arum.board.serviceImpl.BoardServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		BoardServiceImpl board = new BoardServiceImpl();
		board.defaultTest();
		BoardDto dto = new BoardDto();
		dto.setBoard_id(1);
		dto = board.select(dto);
		dto.toString();
	}
}
