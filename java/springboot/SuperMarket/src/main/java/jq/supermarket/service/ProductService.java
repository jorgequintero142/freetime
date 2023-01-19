package jq.supermarket.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jq.supermarket.model.Product;
import jq.supermarket.model.ProductDTO;
import jq.supermarket.model.ProductType;
import jq.supermarket.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product add(Product producto) {

		if (producto == null) {
			throw new IllegalArgumentException("There is an error with product values");
		} else if (producto.getNameProduct() == null) {
			throw new IllegalArgumentException("There is an error with name of product");
		} else if (producto.getPriceProduct() == null || producto.getPriceProduct().compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("There is an error with price");
		} else {
			return productRepo.save(producto);
		}
	}

	public List<Product> paginate() {
		return null;
	}

	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();

	}

	public Product getById(Integer idProduct) {
		Optional<Product> prOpt = productRepo.findById(idProduct);
		if (!prOpt.isPresent()) {
			throw new IllegalStateException(String.format("There is not product with id %d", idProduct));
		}
		return prOpt.get();
	}

	public List<ProductDTO> getInfoAllProducts() {
		List<Product> allProducts = (List<Product>) productRepo.findAll();
		return listProduct2DTO(allProducts);
	}

	private List<ProductDTO> listProduct2DTO(List<Product> listProducts) {
		List<ProductDTO> listProductDTO = new ArrayList<>();
		for (Product prd : listProducts) {
			listProductDTO.add(convert2DTO(prd));
		}
		return listProductDTO;
	}

	public List<ProductDTO> search(Product product) {

		boolean useProductType = false;
		boolean useNameProduct = false;
		useProductType = product.getProductType().getIdProductType() != null
				&& product.getProductType().getIdProductType() > 0;
		useNameProduct = product.getNameProduct() != null && product.getNameProduct().trim().length() > 0;
		if (useProductType && useNameProduct) {
			List<Product> allProducts = (List<Product>) productRepo.searchByTypeProductAndName(
					product.getProductType().getIdProductType(), product.getNameProduct().toUpperCase());
			return this.listProduct2DTO(allProducts);
		} else if (useProductType) {
			List<Product> allProducts = (List<Product>) productRepo
					.searchByTypeProduct(product.getProductType().getIdProductType());
			return this.listProduct2DTO(allProducts);
		} else if (useNameProduct) {
			List<Product> allProducts = (List<Product>) productRepo
					.searchByName(product.getNameProduct().toUpperCase());
			return this.listProduct2DTO(allProducts);
		} else {
			return this.getInfoAllProducts();
		}
	}

	private ProductDTO convert2DTO(Product product) {
		ProductType tipoProducto = product.getProductType();
		String tipo = "";
		if (tipoProducto != null) {
			tipo = tipoProducto.getNameProductType();
		}
		return new ProductDTO(product, tipo);
	}
}
