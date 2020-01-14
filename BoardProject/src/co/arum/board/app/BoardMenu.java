package co.arum.board.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.arum.board.dto.BoardDto;
import co.arum.board.impl.BoardServiceImpl;

public class BoardMenu {
	private final int TO_MAIN = 1;
	private final int TO_LIST = 2;
	private final int TO_SEARCH = 3;
	private final int TO_READ = 4;
	private final int TO_WRITE = 5;
	private final int TO_EXIT = -1;
	
	private Scanner sc = new Scanner(System.in);
	private BoardServiceImpl boardService;
	
	public void run() {
		int selectMenu = 1;
		boolean run = true;
		while(run) {
			switch(selectMenu) {
			case TO_MAIN:
				selectMenu = mainMenu();
				break;
			case TO_LIST:
				selectMenu = boardListMenu();
				break;
			case TO_SEARCH:
				selectMenu = boardSearchMenu();
				break;
			case TO_READ:
				selectMenu = boardReadMenu();
				break;
			case TO_WRITE:
				selectMenu = boardWriteMenu();
				break;
			case TO_EXIT:
				run = false;
				boardService = new BoardServiceImpl();
				boardService.close();
				break;
			default:
				selectMenu = 1;
				break;
			}
		}
		System.out.println("종료합니다.");
	}
	
 	private int mainMenu() {
 		int choice;
 		int returnInt=TO_MAIN;

		System.out.println("--------자유게시판-------");
		System.out.println("    1. 전체글 보기");
		System.out.println("    2. 게시글 검색");
		System.out.println("    3.  종   료  ");
		System.out.println("----------------------");
 		boolean b = true;
 		do {
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				returnInt = TO_LIST;
 				b = false;
 				break;
 			case 2:
 				returnInt = TO_SEARCH;
 				b = false;
 				break;
 			case 3:
 				returnInt = TO_EXIT;
 				b = false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		return returnInt;
 	}

 	private int boardListMenu() {
 		List<BoardDto> list = new ArrayList<BoardDto>();
 		boardService = new BoardServiceImpl();
 		list = boardService.allSelect();
		System.out.println("=번호===작성자======작성일자==============제목==========조회수=");
 		for(BoardDto dto : list) {
 			System.out.print(" " + String.format("%-2d",dto.getBoard_id()) + " ");
 			System.out.print(" " + String.format("%-7s",dto.getWriter()) + " ");
 			System.out.print(" " + dto.getWritedate() + " ");
 			System.out.print(" " + String.format("%-22s",dto.getTitle()) + " ");
 			System.out.println(" " + String.format("%3d",dto.getHit()) + " ");
 		}
 		System.out.println("=====================================================");
		System.out.println("1.글 열람 | 2.글쓰기 | 3.게시글 검색 | 4.메인으로");
 		
 		int choice;
 		int returnInt=TO_MAIN;
 		boolean b = true;
 		do {
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				returnInt = TO_READ;
 				b = false;
 				break;
 			case 2:
 				returnInt = TO_WRITE;
 				b = false;
 				break;
 			case 3:
 				returnInt = TO_SEARCH;
 				b = false;
 				break;
 			case 4:
 				returnInt = TO_MAIN;
 				b = false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		return returnInt;
 	}

 	private int boardSearchMenu() {
 		boardService = new BoardServiceImpl();
 		List<BoardDto> list = new ArrayList<BoardDto>();
 		
 		System.out.print(">검색할 키워드 : ");
 		String inputString = sc.nextLine();
 		list = boardService.search(inputString);
		System.out.println("=번호===작성자======작성일자==============제목==========조회수=");
 		for(BoardDto dto : list) {
 			System.out.print(" " + String.format("%-2d",dto.getBoard_id()) + " ");
 			System.out.print(" " + String.format("%-7s",dto.getWriter()) + " ");
 			System.out.print(" " + dto.getWritedate() + " ");
 			System.out.print(" " + String.format("%-22s",dto.getTitle()) + " ");
 			System.out.println(" " + String.format("%3d",dto.getHit()) + " ");
 		}
 		System.out.println("=====================================================");
		System.out.println("1.글 열람 | 2.글쓰기 | 3.게시글 검색 | 4.메인으로");
		
		int choice;
 		int returnInt=TO_MAIN;
 		boolean b = true;
 		do {
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				returnInt = TO_READ;
 				b = false;
 				break;
 			case 2:
 				returnInt = TO_WRITE;
 				b = false;
 				break;
 			case 3:
 				returnInt = TO_SEARCH;
 				b = false;
 				break;
 			case 4:
 				returnInt = TO_MAIN;
 				b = false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		return returnInt;
 	}

 	private int boardReadMenu() {
 		boardService = new BoardServiceImpl();
 		BoardDto dto = new BoardDto();
 		
 		System.out.print(">열람할 글 번호 : ");
 		int inputNum = sc.nextInt();
 		sc.nextLine();
 		int returnInt=TO_LIST;

 		dto.setBoard_id(inputNum);
 		dto = boardService.select(dto);
 		if(dto != null) {
 			System.out.println("============================");
 			System.out.println("* 게시글번호 : " + dto.getBoard_id());
 			System.out.println("* 작   성   자 : " + dto.getWriter());
 			System.out.println("* 작성   날짜 : " + dto.getWritedate());
 			System.out.println("* 조   회   수 : " + dto.getHit());
 			System.out.println("* 제         목 : " + dto.getTitle());
 			System.out.println("* 내         용 : " + dto.getSubject());
 			System.out.println("============================");
 			System.out.println("1.수정 | 2.삭제 | 3.메인으로");
 			
 	 		int choice;
 	 		boolean b = true;
 	 		do {
 	 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 	 			choice = sc.nextInt();
 	 			sc.nextLine();
 	 			switch(choice) {
 	 			case 1:
 	 				returnInt = boardCorrect(dto);
 	 				b = false;
 	 				break;
 	 			case 2:
 	 				returnInt = boardDelete(dto);
 	 				b = false;
 	 				break;
 	 			case 3:
 	 				returnInt = TO_MAIN;
 	 				b = false;
 	 				break;
 	 			default:
 	 				System.out.println("제대로 입력하십시오");
 	 			}
 	 		}while(b);
 	 		return returnInt;
 		}else {
 			System.out.println("존재하지 않는 글입니다.");
 		}
		return returnInt;
 	}
 	private int boardWriteMenu() {
 		boardService = new BoardServiceImpl();
 		BoardDto dto = new BoardDto();
 		
 		System.out.print(">제목 : ");
 		String inputString = sc.nextLine();
 		dto.setTitle(inputString);
 		System.out.print(">작성자 : ");
 		inputString = sc.nextLine();
 		dto.setWriter(inputString);
 		System.out.print(">내용 : ");
 		inputString = sc.nextLine();
 		dto.setSubject(inputString);
 		int result = boardService.insert(dto);
 		if(result != 0) {
 			System.out.println("완료!");
 		} else {
 			System.out.println("오류. 다시 시도해주십시오.");
 		}
 		
 		int returnInt=TO_MAIN;
		System.out.println("1.목록 | 2.메인으로");
		System.out.print("> 원하는 작업을 선택하십시오 : ");
		int choice;
	 		boolean b = true;
	 		do {
	 			choice = sc.nextInt();
	 			sc.nextLine();
	 			switch(choice) {
	 			case 1:
	 				returnInt = TO_LIST;
	 				b = false;
	 				break;
	 			case 2:
	 				returnInt = TO_MAIN;
	 				b = false;
	 				break;
	 			default:
	 				System.out.println("제대로 입력하십시오");
	 			}
	 		}while(b);
		return returnInt;
 	}
 	private int boardCorrect(BoardDto dto) {
 		boardService = new BoardServiceImpl();
 		System.out.print(">내용 : ");
 		String inputString = sc.nextLine();
 		dto.setSubject(inputString);
 		int result = boardService.update(dto);
 		if(result != 0) {
 			System.out.println("완료!");
 		} else {
 			System.out.println("오류. 다시 시도해주십시오.");
 		}
 		return TO_MAIN;
 	}
 	private int boardDelete(BoardDto dto) {
 		boardService = new BoardServiceImpl();
 		System.out.print(">삭제하시겠습니까?(Y/N) : ");
 		String inputString = sc.nextLine();
 		if (inputString.equals("y") || inputString.equals("Y")) {
 			int result = boardService.delete(dto);
 	 		if(result != 0) {
 	 			System.out.println("완료!");
 	 		} else {
 	 			System.out.println("오류. 다시 시도해주십시오.");
 	 		}
 		}else {
 			System.out.println("취소합니다.");
 		}
 		return TO_MAIN;		
 	}
 	
}
