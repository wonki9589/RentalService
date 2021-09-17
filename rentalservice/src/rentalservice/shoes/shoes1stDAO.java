package rentalservice.shoes;

import rentalservice.user.DBConn;

public class shoes1stDAO extends DBConn {
	public shoes1stDAO() {

	}

	public int ReservationInsert(shoes1stVO vo) {
		int result = 0;

		try{
			getConn();
			sql = "insert into tbl_product(product_id, "
					+ " product_name, product_price, product_quantity ,product_size) "
					+ " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getProduct_id());
			pstmt.setString(2, vo.getProduct_name());
			pstmt.setString(3, vo.getProduct_price());
			pstmt.setString(4, vo.getproduct_quantity());
			pstmt.setString(5, vo.getproduct_size());

			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return result;
		}
}
