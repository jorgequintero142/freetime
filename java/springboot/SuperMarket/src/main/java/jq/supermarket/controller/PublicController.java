package jq.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jq.supermarket.typeofproduct.TypeOfProductService;
import jq.supermarket.product.Product;
import jq.supermarket.product.ProductService;
import jq.supermarket.typeofproduct.TypeOfProduct;

@Controller
@RequestMapping(value = { "", "/", "/public" })
public class PublicController {

	@Autowired
	private ProductService productService;

	@Autowired
	private TypeOfProductService typeOfProductService;

	@GetMapping(value = { "", "/home", "/index" })
	public String home(Model model,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		model.addAttribute("products", productService.getProducts(productService.getAllProducts()));
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		Product product = new Product();
		product.setTypeOfProduct(new TypeOfProduct());
		model.addAttribute("product", product);
		if (authentication.isAuthenticated()
				&& authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			model.addAttribute("isAdmin", true);
		} else {
			model.addAttribute("isAdmin", false);
		}
		return "home";
	}

	@PostMapping(value = "searchProducts")
	public String searchProduct(@ModelAttribute Product product, Model model,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		model.addAttribute("typesofproducts", typeOfProductService.getAllTypeOfProducts());
		model.addAttribute("products", productService.search(product));
		model.addAttribute("product", product);
		if (authentication.isAuthenticated()
				&& authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			model.addAttribute("isAdmin", true);
		} else {
			model.addAttribute("isAdmin", false);
		}

		return "home";
	}
}