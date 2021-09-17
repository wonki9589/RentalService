package rentalservice.manage;



public class shoppingBasketVO {

	private int product_id;
	private String product_name;
	private int product_price;
	private String product_size;
	private String product_quantity;

	public shoppingBasketVO() {
	}

	public shoppingBasketVO(int product_id, String product_name,int product_price,String product_size,String product_quantity) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_size = product_size;
		this.product_quantity = product_quantity;

	}

	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public String getProduct_size() {
		return product_size;
	}
	public String getproduct_quantity() {
		return product_quantity;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}



}