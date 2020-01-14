package co.arum.lms.student;

import java.sql.Date;

public class StudentDto {
	private String student_id;
	private String student_name;
	private String student_dept;
	private Date student_brithday;
	private String dept_name;
	
	public StudentDto() {
	}
	public StudentDto(String student_id, String student_name, String student_dept, Date student_brithday) { //insert구문에 활용
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_dept = student_dept;
		this.student_brithday = student_brithday;
	}
	public StudentDto(String student_id, String student_name, String student_dept, Date student_brithday,
			String dept_name) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_dept = student_dept;
		this.student_brithday = student_brithday;
		this.dept_name = dept_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_dept() {
		return student_dept;
	}

	public void setStudent_dept(String student_dept) {
		this.student_dept = student_dept;
	}

	public Date getStudent_brithday() {
		return student_brithday;
	}

	public void setStudent_brithday(Date student_brithday) {
		this.student_brithday = student_brithday;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
