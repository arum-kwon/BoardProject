package co.arum.board.dto;

import java.sql.Date;

public class BoardDto {
	private int board_id;
	private String writer;
	private Date writedate;
	private String title;
	private String subject;
	private int hit;
	
	public BoardDto() {
	}
	public BoardDto(int id, String writer, String title, String subject) {
		this.board_id = id;
		this.writer = writer;
		this.title = title;
		this.subject = subject;
	}
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "[board_id=" + board_id + ", writer=" + writer + ", writedate=" + writedate + ", title=" + title
				+ ", subject=" + subject + ", hit=" + hit + "]";
	}

}
