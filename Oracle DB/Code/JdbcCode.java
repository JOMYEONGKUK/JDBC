package JDBC; // 패키지 선언

import java.sql.Connection; // sql.Connection 모듈 호출
import java.sql.DriverManager; // sql.DriverManager 모듈 호출
import java.sql.ResultSet; // sql.ResultSet 모듈 호출
import java.sql.SQLException; // sql.SQLException 모듈 호출
import java.sql.Statement; // sql.Statement 모듈 호출

// 클래스명 클래스 호출
public class JdbcCode {
	
	private static final String driver="oracle.jdbc.driver.OracleDriver"; // 드라이버 로딩
	private static final String url="jdbc:oracle:thin:@localhost:1521:orcl"; // JDBC 로딩
	private static final String user="egoing"; // Oracle Datbase 사용자 계정 아이디
	private static final String pwd="111111"; // Oracle Datbase 사용자 계정 비밀번호
	
	// 메소드 선언(public), 정적 메소드(static), 리턴값 없음(void), 메소드 이름(main)
	public static void main(String[] args) {
		
		Connection conn; // Connection 객체 반환 변수 coon 선언
		Statement stmt; // Statement 객체 변수 stmt 선언
		ResultSet rs; // 결과값 불러오는 ResultSet 객체 변수 rs 선언
		
		try { // try문
			Class.forName(driver); // Class.forName을 이용해서 드라이버 로드
			System.out.println("Oracle 드라이버 로딩 성공"); // Oracle 드라이버 로딩 성공 후 출력문
			conn = DriverManager.getConnection(url,user,pwd); // 로드된 드라이버를 통해서 Connection 객체 활성화
			System.out.println("Connection 생성 성공"); // Connection 생성 성공 후 출력문	
			
			stmt=conn.createStatement(); // Statement 객체 생성
			System.out.println("Statement 객체 생성 성공"); // Statement 객체 생성 성공 후 출력문
			
			String query="insert into TOPIC values(4010,'Apeach','Apeach Class')"; // 문자열 변수 선언 후 TOPIC 테이블에 행 추가
			System.out.println(query); // 추가한 행 출력
			
			stmt.executeUpdate(query); // 추가한 행 Update
			String query2="select * from TOPIC"; // 문자열 변수 선언 후 TOPIC 테이블 조회
			System.out.println(query2); // 추가한 행 조회 및 출력
			
			rs=stmt.executeQuery(query2); // 테이블에서 데이터 검색
			
			while(rs.next()) { // 결과값 변수 rs 반복문 while문 돌림
				System.out.println("아이디는>>"+rs.getString("id")); // 추가 된 데이터 id 출력
				System.out.println("이름은>>"+rs.getString("title")); // 추가 된 데이터 title 출력
				System.out.println("추가된 데이터 내용은>>"+rs.getString("description")); // 추가 된 데이터 description 출력문
			
			} // End while
			
			// 자원해제
			rs.close(); // rs 연결해제
			stmt.close(); // stmt 연결해제
			conn.close(); // conn 연결해제 
		
		} catch (ClassNotFoundException e) { // ClassNotFoundException 에러가 발생 했을 때
			e.printStackTrace(); // 어떤 예외가 발생했는지 출력
		
		} // End 첫번째 catch
		
		catch (SQLException e) { // SQLException 에러가 발생 했을 때
			e.printStackTrace(); // 어떤 예외가 발생했는지 출력
		
		} // End 두번째 catch
	
	} // End main

} // End JdbcCode
