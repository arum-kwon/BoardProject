package co.arum.board.dto;

import java.sql.Date;

public class BoardDto {
	private int board_id;
	private String writer;
	private Date writeDate;
	private String title;
	private String subject;
	private int hit;
	
	public BoardDto(){
		
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
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
		System.out.println("[board_id=" + board_id + ", writer=" + writer +	", writeDate=" + writeDate
				+ ", title=" + title + ", subject=" + subject + ", hit=" + hit + "]");
		return null;
	}
	
	
}
