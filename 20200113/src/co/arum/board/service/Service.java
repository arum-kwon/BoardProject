package co.arum.board.service;

import java.util.List;

import co.arum.board.dto.BoardDto;

public interface Service {
	
	default void defaultTest() {
		System.out.println("default Test . . . .");
	}
	public <E> List<E> allSelect();
	public BoardDto select(BoardDto e);
	public <E> int update(E e);
	public <E> int insert(E e);
	public <E> int delete(E e);
}
