package rentalservice.user;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rentalservice.user.exuserinfosetVO;

public class exuserinfosetDAO extends DBConn {


	public exuserinfosetDAO() {
	}

	public List<exuserinfosetVO> setDetailPage(String id) {
		List<exuserinfosetVO> lst3 = new ArrayList<exuserinfosetVO>();
		try {
			getConn();
			sql = "select product_id,product_name,product_desc from tbl_product";
			Statement stmt = conn.createStatement();

			rs = pstmt.executeQuery(sql);
				//

			ArrayList<exuserinfosetVO> list3 = new ArrayList<exuserinfosetVO>();

			//여기서부터 다시 작업
			while(rs.next()) {
				exuserinfosetVO vo3 = new exuserinfosetVO();
				vo3.setshoesNo(rs.getInt("product_id"));
				vo3.setshoesName(rs.getString("product_name"));
				vo3.setshoesDesc(rs.getString("product_desc"));

				list3.add(vo3);
				}
			for(int i =0 ; i < list3.size(); i++) {
				System.out.println("회원번호  : "+list3.get(i).getshoesNo());
				System.out.println("회원이메일 : "+list3.get(i).getshoesName());
				System.out.println("회원이메일 : "+list3.get(i).getshoesDesc());
			}
			System.out.println("-------------------------------------- ");
			System.out.println("여기까지 ac_shoes 테이블 쿼리사용한거  ");
			}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("처리ㅁㅁ실패 ");
		} finally {
			dbClose();
		}
		return lst3;
}
	}
