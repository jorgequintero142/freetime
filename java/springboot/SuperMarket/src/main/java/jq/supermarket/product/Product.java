package jq.supermarket.product;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jq.supermarket.typeofproduct.TypeOfProduct;

@Entity
public class Product {

	@Id
	@SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Integer idProduct;
	private String nameProduct;

	@ManyToOne
	@JoinColumn(name = "idProductType")
	private TypeOfProduct typeOfProduct;
	private BigDecimal priceProduct;

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

	public TypeOfProduct getTypeOfProduct() {
		return typeOfProduct;
	}

	public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public BigDecimal getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(BigDecimal priceProduct) {
		this.priceProduct = priceProduct;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", priceProduct=" + priceProduct
				+ "]";
	}

}