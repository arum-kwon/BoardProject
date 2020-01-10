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
	
 	public int mainMenu() {
 		int choice;
 		int returnInt=TO_MAIN;
 		boolean b = false;
 		do {
 			System.out.println("--------자유게시판-------");
 			System.out.println("    1. 전체글 보기");
 			System.out.println("    2. 게시글 검색");
 			System.out.println("    2.  종   료  ");
 			System.out.println("----------------------");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				returnInt = TO_LIST;
 				break;
 			case 2:
 				returnInt = TO_SEARCH;
 				break;
 			case 3:
 				returnInt = TO_EXIT;
 				break;
 			default:
 				b=true;
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
 		
 		int choice;
 		int returnInt=TO_MAIN;
 		boolean b = false;
 		do {
 			System.out.println("1.글 열람 | 2.글쓰기 | 3.게시글 검색 | 4.메인으로");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				returnInt = TO_READ;
 				break;
 			case 2:
 				returnInt = TO_WRITE;
 				break;
 			case 3:
 				returnInt = TO_SEARCH;
 				break;
 			case 4:
 				returnInt = TO_MAIN;
 				break;
 			default:
 				b=true;
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		return returnInt;
 	}
 	private void boardSearchMenu() {
 		
 	}
 	private void boardReadMenu() {
 		boardService = new BoardServiceImpl();
 		BoardDto dto = new BoardDto();
 		
 		System.out.print(">열람할 글 번호 : ");
 		int inputNum = sc.nextInt();
 		sc.nextLine();
 		dto.setBoard_id(inputNum);
 		dto = boardService.select(dto);
 		if(dto != null) {
 			System.out.println("============================");
 			System.out.print("");
 			System.out.println("============================");
 		}else {
 			System.out.println("존재하지 않는 글입니다.");
 		}
 	}
 	private void boardWriteMenu() {
 		
 	}
 	private void boardCorrectMenu() {
 		
 	}
 	private void boardDeleteMenu() {
 		
 	}
 	
}
