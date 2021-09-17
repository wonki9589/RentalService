package rentalservice.manage;

public class CustomReservation3VO {
	private String orderuser_name;
	private String orderuser_ename;
	private String orderuser_zipcode;
	private String orderuser_address;
	private String orderuser_birth;
	private String orderuser_tel;
	private String orderuser_email;
	private String orderuser_gender;

	public CustomReservation3VO() {	}

	public CustomReservation3VO(String orderuser_name, String orderuser_ename,
			String zipcode, String orderuser_address, String bir,
			String orderuser_tel, String orderuser_email,String orderuser_gender) {
		this.orderuser_name = orderuser_name;
		this.orderuser_ename = orderuser_ename;
		this.orderuser_zipcode = zipcode;
		this.orderuser_address = orderuser_address;
		this.orderuser_birth = bir;
		this.orderuser_tel = orderuser_tel;
		this.orderuser_email = orderuser_email;
		this.orderuser_gender = orderuser_gender;
	}

	public CustomReservation3VO(String orderuser_name) {
		this.orderuser_name = orderuser_name;
	}

	public String getOrderuser_name() {
		return orderuser_name;
	}
	public void setOrderuser_name(String orderuser_name) {
		this.orderuser_name = orderuser_name;
	}
	public String getOrderuser_ename() {
		return orderuser_ename;
	}
	public void setOrderuser_ename(String orderuser_ename) {
		this.orderuser_ename = orderuser_ename;
	}
	public String getOrderuser_zipcode() {
		return orderuser_zipcode;
	}
	public void setOrderuser_zipcode(String orderuser_zipcode ) {
		this.orderuser_zipcode = orderuser_zipcode;
	}
	public String getOrderuser_address() {
		return orderuser_address;
	}
	public void setOrderuser_address(String orderuser_address) {
		this.orderuser_address = orderuser_address;
	}
	public String getOrderuser_birth() {
		return orderuser_birth;
	}
	public void setOrderuser_birth(String orderuser_birth) {
		this.orderuser_birth = orderuser_birth;
	}
	public String getOrderuser_tel() {
		return orderuser_tel;
	}
	public void setOrderuser_tel(String orderuser_tel) {
		this.orderuser_tel = orderuser_tel;
	}
	public String getOrderuser_email() {
		return orderuser_email;
	}
	public void setOrderuser_email(String orderuser_email) {
		this.orderuser_email = orderuser_email;
	}
	public String getOrderuser_gender() {
		return orderuser_gender;
	}
	public void setOrderuser_gender(String orderuser_gender) {
		this.orderuser_gender = orderuser_gender;
	}

}
