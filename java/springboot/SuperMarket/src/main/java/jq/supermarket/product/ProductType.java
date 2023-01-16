package jq.supermarket.product;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ProductType {

	@Id
	private Integer idProductType;
	private String nameProductType;
	@OneToMany(mappedBy = "productType")
	private Set<Product> products;

	public ProductType() {
	}

	public ProductType(Integer idProductType, String nameProductType) {
		super();
		this.idProductType = idProductType;
		this.nameProductType = nameProductType;
	}

	public Integer getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(Integer idProductType) {
		this.idProductType = idProductType;
	}

	public String getNameProductType() {
		return nameProductType;
	}

	public void setNameProductType(String nameProductType) {
		this.nameProductType = nameProductType;
	}
}