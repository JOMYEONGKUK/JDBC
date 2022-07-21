package JDBC; // ��Ű�� ����

import java.sql.Connection; // sql.Connection ��� ȣ��
import java.sql.DriverManager; // sql.DriverManager ��� ȣ��
import java.sql.ResultSet; // sql.ResultSet ��� ȣ��
import java.sql.SQLException; // sql.SQLException ��� ȣ��
import java.sql.Statement; // sql.Statement ��� ȣ��

// Ŭ������ Ŭ���� ȣ��
public class JdbcCode {
	
	private static final String driver="oracle.jdbc.driver.OracleDriver"; // ����̹� �ε�
	private static final String url="jdbc:oracle:thin:@localhost:1521:orcl"; // JDBC �ε�
	private static final String user="egoing"; // Oracle Datbase ����� ���� ���̵�
	private static final String pwd="111111"; // Oracle Datbase ����� ���� ��й�ȣ
	
	// �޼ҵ� ����(public), ���� �޼ҵ�(static), ���ϰ� ����(void), �޼ҵ� �̸�(main)
	public static void main(String[] args) {
		
		Connection conn; // Connection ��ü ��ȯ ���� coon ����
		Statement stmt; // Statement ��ü ���� stmt ����
		ResultSet rs; // ����� �ҷ����� ResultSet ��ü ���� rs ����
		
		try { // try��
			Class.forName(driver); // Class.forName�� �̿��ؼ� ����̹� �ε�
			System.out.println("Oracle ����̹� �ε� ����"); // Oracle ����̹� �ε� ���� �� ��¹�
			conn = DriverManager.getConnection(url,user,pwd); // �ε�� ����̹��� ���ؼ� Connection ��ü Ȱ��ȭ
			System.out.println("Connection ���� ����"); // Connection ���� ���� �� ��¹�	
			
			stmt=conn.createStatement(); // Statement ��ü ����
			System.out.println("Statement ��ü ���� ����"); // Statement ��ü ���� ���� �� ��¹�
			
			String query="insert into TOPIC values(4010,'Apeach','Apeach Class')"; // ���ڿ� ���� ���� �� TOPIC ���̺� �� �߰�
			System.out.println(query); // �߰��� �� ���
			
			stmt.executeUpdate(query); // �߰��� �� Update
			String query2="select * from TOPIC"; // ���ڿ� ���� ���� �� TOPIC ���̺� ��ȸ
			System.out.println(query2); // �߰��� �� ��ȸ �� ���
			
			rs=stmt.executeQuery(query2); // ���̺��� ������ �˻�
			
			while(rs.next()) { // ����� ���� rs �ݺ��� while�� ����
				System.out.println("���̵��>>"+rs.getString("id")); // �߰� �� ������ id ���
				System.out.println("�̸���>>"+rs.getString("title")); // �߰� �� ������ title ���
				System.out.println("�߰��� ������ ������>>"+rs.getString("description")); // �߰� �� ������ description ��¹�
			
			} // End while
			
			// �ڿ�����
			rs.close(); // rs ��������
			stmt.close(); // stmt ��������
			conn.close(); // conn �������� 
		
		} catch (ClassNotFoundException e) { // ClassNotFoundException ������ �߻� ���� ��
			e.printStackTrace(); // � ���ܰ� �߻��ߴ��� ���
		
		} // End ù��° catch
		
		catch (SQLException e) { // SQLException ������ �߻� ���� ��
			e.printStackTrace(); // � ���ܰ� �߻��ߴ��� ���
		
		} // End �ι�° catch
	
	} // End main

} // End JdbcCode
