package jq.supermarket.product;

public class ProductDTO {
	private Product product;
	private String nameTypeOfProduct;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Product product, String nameTypeOfProduct) {
		super();
		this.product = product;
		this.nameTypeOfProduct = nameTypeOfProduct;
	}

	public String getNameTypeOfProduct() {
		return nameTypeOfProduct;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "ProductDTO [product=" + product + ", nameTypeOfProduct=" + nameTypeOfProduct + "]";
	}
}