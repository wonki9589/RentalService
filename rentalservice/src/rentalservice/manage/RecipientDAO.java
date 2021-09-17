package rentalservice.manage;

import rentalservice.user.DBConn;

public class RecipientDAO extends DBConn {
	public RecipientDAO() {
	}
	// 수령자 db insert
	public int ReservationInsert(RecipientVO vo3) {
		int result = 0;

	try{
		getConn();
		sql = "insert into tbl_orderuser(orderuser_name, "
				+ " orderuser_ename,orderuser_zipcode,orderuser_address,orderuser_birth,orderuser_tel,orderuser_email,orderuser_gender) "
				+ " values(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo3.getOrderuser_name());
		pstmt.setString(2, vo3.getOrderuser_ename());
		pstmt.setString(3, vo3.getOrderuser_zipcode());
		pstmt.setString(4, vo3.getOrderuser_address());
		pstmt.setString(5, vo3.getOrderuser_birth());
		pstmt.setString(6, vo3.getOrderuser_tel());
		pstmt.setString(7, vo3.getOrderuser_email());
		pstmt.setString(8, vo3.getOrderuser_gender());
		result = pstmt.executeUpdate();

	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		dbClose();
	}
	return result;
	}

}
