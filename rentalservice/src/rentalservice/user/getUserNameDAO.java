package rentalservice.user;



import java.util.ArrayList;

import java.util.List;

import rentalservice.user.getUserNameVO;


public class getUserNameDAO extends DBConn {
	public getUserNameDAO() {
	}

	public List<getUserNameVO> getName(String user_id) {
		List<getUserNameVO> lst = new ArrayList<getUserNameVO>();
		try {
			getConn();
			sql = "select user_name from tbl_user where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				getUserNameVO vo = new getUserNameVO();
				vo.setUser_name(rs.getString(1));
				lst.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return lst;
	}
}
