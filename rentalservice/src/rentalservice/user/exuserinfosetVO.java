package rentalservice.user;



public class exuserinfosetVO {
	private int shoesNo;
	private String shoesName;
	private String shoesDesc;



	public exuserinfosetVO() {
	}



	public exuserinfosetVO(String shoesName, int shoesNo, String shoesDesc) {
		this.shoesNo = shoesNo;
		this.shoesDesc = shoesDesc;
		this.shoesName = shoesName;
		this.setshoesNo(shoesNo);
	}


	//================================== get and set

	public int getshoesNo() {
		return shoesNo;
	}

	public void setshoesNo(int shoesNo) {
		this.shoesNo = shoesNo;
	}



	public String getshoesName() {
		return shoesName;
	}

	public void setshoesName(String shoesName) {
		this.shoesName = shoesName;
	}



	public String getshoesDesc() {
		return shoesDesc;
	}

	public void setshoesDesc(String shoesDesc) {
		this.shoesDesc = shoesDesc;
	}



}

