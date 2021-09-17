package rentalservice.user;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBConn {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			}
		catch(Exception e) {
			System.out.println("DB로딩 에러발생"+e.getMessage());
			}
		}
	protected static String sql = null;
	protected static Connection conn = null;
	protected static PreparedStatement pstmt = null;
	protected static ResultSet rs = null;
	static String url = "jdbc:mariadb://127.0.0.1:3306/teamProject";
	static String username = "root";
	static String userpwd = "mariadb";
	public DBConn() {}
	public static void getConn() {
		try { conn = DriverManager.getConnection(url,username,userpwd);
		}
		catch(Exception e) {
			System.out.println("DB연결 에러발생"+e.getMessage());
			}
		}
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			}
		catch(Exception e) {
			System.out.println("DB종료가 실패하였습니다."+e.getMessage());
			}
	}
}