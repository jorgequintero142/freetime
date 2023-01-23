package jq.supermarket.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jq.supermarket.typeofproduct.TypeOfProduct;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product add(Product producto) {

		if (producto == null) {
			throw new IllegalArgumentException("There is an error with product values");
		} else if (producto.getNameProduct() == null) {
			throw new IllegalArgumentException("There is an error with name of product");
		} else if (producto.getPriceProduct() == null || producto.getPriceProduct().compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("There is an error with price");
		} else {
			return productRepository.save(producto);
		}
	}

	public List<Product> paginate() {
		return null;
	}

	/**
	 * return a list with all products found in database
	 * 
	 * @return
	 */
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	/**
	 * return a list of products converted as DTO
	 * 
	 * @param products
	 * @return
	 */
	public List<ProductDTO> getProducts(List<Product> products) {
		List<ProductDTO> newProducts = new ArrayList<>();
		ProductHelper productHelper = new ProductHelper();
		for (Product product : products) {
			newProducts.add(productHelper.product2DTO(product));
		}
		return newProducts;
	}

	public Product getProductById(Integer idProduct) {
		Optional<Product> product = productRepository.findById(idProduct);
		if (!product.isPresent()) {
			throw new IllegalStateException(String.format("There is not product with id %d", idProduct));
		}
		return product.get();
	}

	/**
	 * 
	 * @param product
	 * @return
	 */
	public List<ProductDTO> search(Product product) {

		boolean useProductType = false;
		boolean useNameProduct = false;
		useProductType = product.getTypeOfProduct().getIdTypeOfProduct() != null
				&& product.getTypeOfProduct().getIdTypeOfProduct() > 0;
		useNameProduct = product.getNameProduct() != null && product.getNameProduct().trim().length() > 0;
		if (useProductType && useNameProduct) {
			List<Product> allProducts = (List<Product>) productRepository.searchByTypeProductAndName(
					product.getTypeOfProduct().getIdTypeOfProduct(), product.getNameProduct().toUpperCase());
			return this.getProducts(allProducts);
		} else if (useProductType) {
			List<Product> allProducts = (List<Product>) productRepository
					.searchByTypeProduct(product.getTypeOfProduct().getIdTypeOfProduct());
			return this.getProducts(allProducts);
		} else if (useNameProduct) {
			List<Product> allProducts = (List<Product>) productRepository
					.searchByName(product.getNameProduct().toUpperCase());
			return this.getProducts(allProducts);
		} else {
			return this.getProducts((List<Product>) productRepository.findAll());
		}
	}

}
