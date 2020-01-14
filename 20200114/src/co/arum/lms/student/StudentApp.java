package co.arum.lms.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	StudentServiceImpl student = new StudentServiceImpl();
	Scanner sc = new Scanner(System.in);
	
	public void selectAll() {
		List<StudentDto> list = new ArrayList<StudentDto>();
		list = student.allStudent();
		printStudentList(list);
	}
	public void select() {
		StudentDto dto = new StudentDto();
		System.out.println("[학생 검색]");
		System.out.print("학번 입력 > ");
		dto.setStudent_id(sc.nextLine());
		
		dto = student.select(dto);
		if(dto != null) {
			printStudent(dto);
		}else {
			System.out.println("Not found");
		}
	}
	public void insert() {
		StudentDto dto = new StudentDto();
		System.out.println("[학생 추가]");
		do {
			System.out.print("학번 입력 > ");
			String id = sc.nextLine();
			boolean b = student.isCheckId(id);					
			dto.setStudent_id(id);
			if(!b){
				System.out.println("이미 존재하는 번호. 다시 입력");
			}else {
				break;
			}
		}while(true);
		System.out.print("이름 입력 > ");
		dto.setStudent_name(sc.nextLine());
		System.out.print("학과번호 입력 > ");
		dto.setStudent_dept(sc.nextLine());
		System.out.print("생년월일 입력(yyyy-mm-dd) > ");
		dto.setStudent_brithday(Date.valueOf(sc.nextLine()));
		int n =student.insert(dto);
		if(n != 0) {
			System.out.println("COMPLETE");
		}else{
			System.out.println("FAIL");
		}
	}
	public void login() {
		System.out.println("[로그인]");
		System.out.print("ID > ");
		String id = sc.nextLine();
		System.out.print("PW > ");
		String pw = sc.nextLine();
		String name = student.loginCheck(id, pw);
		if(name == null) {
			System.out.println("없는 아이디이거나 비밀번호가 틀렸습니다.");
		}else {
			System.out.println(name + " 님 환영합니다.");
		}
	}
	
	private void printStudent(StudentDto dto) {
		System.out.print(dto.getStudent_id() + " ");
		System.out.print(String.format("%7s", dto.getStudent_name()) + " ");
		System.out.print(String.format("%7s", dto.getDept_name()) + " ");
		System.out.println(dto.getStudent_brithday() + " ");
	}

	private void printStudentList(List<StudentDto> list) {
		for(StudentDto dto : list) {
			System.out.print(dto.getStudent_id() + " ");
			System.out.print(String.format("%7s", dto.getStudent_name()) + " ");
			System.out.print(String.format("%7s", dto.getDept_name()) + " ");
			System.out.println(dto.getStudent_brithday() + " ");
		}
	}
	
}
