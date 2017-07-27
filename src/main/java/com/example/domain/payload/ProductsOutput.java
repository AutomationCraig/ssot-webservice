package com.example.domain.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Product;
import com.example.domain.prettyOutputs.PrettyProduct;

public class ProductsOutput {
	
	private List<PrettyProduct> products;
	
	public ProductsOutput(List<Product> products) {
		super();
		List<PrettyProduct> allPrettyProducts = new ArrayList<PrettyProduct>();
		for (Product product : products) {
			PrettyProduct prettyProduct = new PrettyProduct(product);
			allPrettyProducts.add(prettyProduct);
		}
		this.products = allPrettyProducts;
	}


	public List<PrettyProduct> getProjects() {
		return products;
	}

	
}
