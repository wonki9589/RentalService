package rentalservice.manage;

import java.util.ArrayList;
import java.util.List;

import rentalservice.user.DBConn;
import rentalservice.user.SignUpVO;

public class CustomReservation3DAO extends DBConn {
	public CustomReservation3DAO() {
	}

	public int SignUpInsert(CustomReservation3VO vo) {
		int result = 0;


	try{
		getConn();

		System.out.println("dd2222dd");

		sql = "insert into tbl_orderuser(orderuser_name, "
				+ " orderuser_ename,orderuser_zipcode,orderuser_address,orderuser_birth,orderuser_tel,orderuser_email,orderuser_gender) "
				+ " values(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getOrderuser_name());
		pstmt.setString(2, vo.getOrderuser_ename());
		pstmt.setString(3, vo.getOrderuser_zipcode());
		pstmt.setString(4, vo.getOrderuser_address());
		pstmt.setString(5, vo.getOrderuser_birth());
		pstmt.setString(6, vo.getOrderuser_tel());
		pstmt.setString(7, vo.getOrderuser_email());
		pstmt.setString(8, vo.getOrderuser_gender());

		result = pstmt.executeUpdate();
		System.out.println("dddd");
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		dbClose();
	}
	return result;
}


		// 회원 아이디 비밀번호 검색 , 회원 유무 확인
	public List<CustomReservation3VO> getenameCheck(String orderuser_ename){
		List<CustomReservation3VO> lst = new ArrayList<CustomReservation3VO>();
		try {
			getConn();
			 sql = "select orderuser_ename from tbl_orderuser";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, orderuser_ename);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 CustomReservation3VO vo = new CustomReservation3VO();
				 vo.setOrderuser_ename(rs.getString(1));
				 lst.add(vo);
		}

	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("처리 실패");
	}finally{
		dbClose();
	}
	return lst;
	}

}
