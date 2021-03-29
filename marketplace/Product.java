package marketplace;

public class Product {
	private String productId;
	private float price;

	public Product (String productId, float price) {
		this.productId = productId;
		this.price = price;
	}

	public float getPrice () {
		return this.price;
	}

	public String getProductId () {
		return this.productId;
	}
}