package rentalservice.manage;


public class DepositVO {
	private int userNo;
	//private int deposit;
	private String user_name;
	private int count;
	private String tel;
	private String mail;

	public DepositVO() {
	}

	public DepositVO(int count) {
		this.count = count;
	}

	public DepositVO(String user_name, int userNo, String tel, String email) {
		this.userNo = userNo;
		//this.deposit = deposit;
		this.user_name = user_name;
		this.setTel(tel);
		this.setMail(mail);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

//	public int getDeposit() {
//		return deposit;
//	}
//
//	public void setDeposit(int deposit) {
//		this.deposit = deposit;
//	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


}
