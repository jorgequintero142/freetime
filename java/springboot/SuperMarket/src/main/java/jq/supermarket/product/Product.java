package jq.supermarket.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private Integer idProduct;
	private String nameProduct;
	@ManyToOne
	@JoinColumn(name = "idProductType")
	private ProductType productType;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProcut) {
		this.idProduct = idProcut;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

}
