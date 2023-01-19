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

import jq.supermarket.model.Product;
import jq.supermarket.model.ProductType;
import jq.supermarket.service.ProductService;
import jq.supermarket.service.ProductTypeService;

@Controller
@RequestMapping(value = { "", "/", "/public" })
public class PublicController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeService productTypeService;

	@GetMapping(value = { "", "/home", "/index" })
	public String home(Model model,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		model.addAttribute("products", productService.getInfoAllProducts());
		model.addAttribute("typesprod", productTypeService.getAll());
		Product pr = new Product();
		pr.setProductType(new ProductType());
		model.addAttribute("product", pr);
		if (authentication.isAuthenticated()
				&& authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			model.addAttribute("isAdmin", true);
		} else {
			model.addAttribute("isAdmin", false);
		}
		return "home";
	}

	@PostMapping(value = "searchProducts")
	public String searchProduct(@ModelAttribute Product pr, Model model,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		model.addAttribute("typesprod", productTypeService.getAll());
		model.addAttribute("products", productService.search(pr));
		model.addAttribute("product", pr);
		if (authentication.isAuthenticated()
				&& authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			model.addAttribute("isAdmin", true);
		} else {
			model.addAttribute("isAdmin", false);
		}

		return "home";
	}
}