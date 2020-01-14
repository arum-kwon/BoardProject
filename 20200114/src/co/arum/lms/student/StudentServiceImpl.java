package co.arum.lms.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.arum.lms.DAO;

public class StudentServiceImpl extends DAO implements StudentService {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String SELECT_ALL = "SELECT STUDENT_ID, STUDENT_NAME, STUDENT_DEPT, DEPT_NAME, STUDENT_BRITHDAY FROM STUDENT, DEPT " + 
			"WHERE STUDENT_DEPT=DEPT_CODE ORDER BY STUDENT_ID";
	private final String SELECT = "SELECT STUDENT_ID, STUDENT_NAME, STUDENT_DEPT, DEPT_NAME, STUDENT_BRITHDAY FROM STUDENT, DEPT " + 
			"WHERE STUDENT_DEPT=DEPT_CODE AND STUDENT_ID = ?";		
	private final String INSERT = "INSERT INTO STUDENT (STUDENT_ID, STUDENT_NAME, STUDENT_DEPT, STUDENT_BRITHDAY) VALUES (?, ?, ?, ?)";
	
	@Override
	public List<StudentDto> allStudent() {
		List<StudentDto> list = new ArrayList<StudentDto>();
		StudentDto dto;
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new StudentDto();
				dto.setStudent_id(rs.getString("student_id"));
				dto.setStudent_name(rs.getString("student_name"));
				dto.setStudent_dept(rs.getString("student_dept"));
				dto.setDept_name(rs.getString("dept_name"));
				dto.setStudent_brithday(rs.getDate("student_brithday"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public StudentDto select(StudentDto dto) {
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setString(1, dto.getStudent_id());
			rs = psmt.executeQuery();
			dto = new StudentDto();
			if(rs.next()) {
				dto.setStudent_id(rs.getString("student_id"));
				dto.setStudent_name(rs.getString("student_name"));
				dto.setStudent_dept(rs.getString("student_dept"));
				dto.setDept_name(rs.getString("dept_name"));
				dto.setStudent_brithday(rs.getDate("student_brithday"));
			}else {
				dto = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(StudentDto dto) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, dto.getStudent_id());
			psmt.setString(2, dto.getStudent_name());
			psmt.setString(3, dto.getStudent_dept());
			psmt.setDate(4, dto.getStudent_brithday());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public int update(StudentDto dto) {
		return 0;
	}

	@Override
	public int delete(StudentDto dto) {
		return 0;
	}

	@Override
	public void close() {
	}

	public boolean isCheckId(String id) { //존재하면 false, 존재하지 않으면 true
		boolean b = true;
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b=false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public String loginCheck(String id, String pw) {
		String sql = "SELECT STUDENT_NAME FROM STUDENT WHERE STUDENT_ID=(SELECT ID FROM LOGIN WHERE ID=? AND PASSWORD=?)";
		String result = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()){
				result = rs.getString("STUDENT_NAME");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
