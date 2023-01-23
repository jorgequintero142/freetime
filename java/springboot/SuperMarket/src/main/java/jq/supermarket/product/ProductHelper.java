package jq.supermarket.product;

import jq.supermarket.typeofproduct.TypeOfProduct;

class ProductHelper {
	ProductDTO product2DTO(Product product) {
		TypeOfProduct tipoProducto = product.getTypeOfProduct();
		String tipo = "";
		if (tipoProducto != null) {
			tipo = tipoProducto.getNameTypeOfProduct();
		}
		return new ProductDTO(product, tipo);
	}
}
