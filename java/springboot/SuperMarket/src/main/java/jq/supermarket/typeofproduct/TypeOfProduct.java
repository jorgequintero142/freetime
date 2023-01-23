package jq.supermarket.typeofproduct;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jq.supermarket.product.Product;

@Entity
public class TypeOfProduct {

	@Id
	private Integer idTypeOfProduct;
	private String nameTypeOfProduct;
	@OneToMany(mappedBy = "typeOfProduct")
	private Set<Product> products;

	public TypeOfProduct() {
	}

	public TypeOfProduct(Integer idTypeOfProduct, String nameTypeOfProduct) {
		super();
		this.idTypeOfProduct = idTypeOfProduct;
		this.nameTypeOfProduct = nameTypeOfProduct;
	}

	public Integer getIdTypeOfProduct() {
		return idTypeOfProduct;
	}

	public void setIdTypeOfProduct(Integer idProductType) {
		this.idTypeOfProduct = idProductType;
	}

	public String getNameTypeOfProduct() {
		return nameTypeOfProduct;
	}

	@Override
	public String toString() {
		return "ProductType [idTypeOfProduct=" + idTypeOfProduct + ", nameTypeOfProduct=" + nameTypeOfProduct + "]";
	}

	public void setNameTypeOfProduct(String nameProductType) {
		this.nameTypeOfProduct = nameProductType;
	}
}