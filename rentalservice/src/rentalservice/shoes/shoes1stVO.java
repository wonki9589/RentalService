package rentalservice.shoes;

public class shoes1stVO {
	private String product_id;
	private String product_name;
	private String product_price;
	private String product_quantity;
	private String product_size;


	public shoes1stVO () {

	}
	public shoes1stVO(String product_id, String product_name, String product_price, String product_quantity, String product_size) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_size = product_size;
	}
	public String getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public String getproduct_quantity() {
		return product_quantity;
	}
	public String getproduct_size() {
		return product_size;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}

}
