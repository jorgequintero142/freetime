package jq.supermarket.model;

public class ProductDTO {
	private Product product;
	private String typeProduct;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDTO() {
		super();
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	@Override
	public String toString() {
		return "ProductDTO [product=" + product + ", typeProduct=" + typeProduct + "]";
	}

	public ProductDTO(Product product, String typeProduct) {
		super();
		this.product = product;
		this.typeProduct = typeProduct;
	}

}