
package rentalservice.manage;
import rentalservice.user.DBConn;
import java.util.ArrayList;
import java.util.List;

import rentalservice.user.DBConn;

public class DepositDAO extends DBConn {
	public DepositDAO() {
	}

	public List<DepositVO> setMypage(String id) {
		List<DepositVO> lst = new ArrayList<DepositVO>();
		try {
			getConn();
			sql = "select user_name,userNo from tbl_user where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 결과를 담을 list 생성
			ArrayList<DepositVO> list = new ArrayList<DepositVO>();

			while (rs.next()) {
				DepositVO vo = new DepositVO();
				vo.setUser_name(rs.getString(1));
				vo.setUserNo(rs.getInt(2));
				//vo.setDeposit(rs.getInt(3));
				lst.add(vo);
			}

			for(int i =0 ; i < list.size(); i++) {
				System.out.println("회원인덱스 : "+list.get(i).getUserNo());
				System.out.println("회원이름 : "+list.get(i).getUser_name());

			}
			System.out.println("-------------------------------------- ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("처리 실패");
		} finally {
			dbClose();
		}
		return lst;
	}


}
