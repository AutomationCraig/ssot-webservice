package com.example.domain.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Product;
import com.example.domain.prettyOutputs.PrettyProductOnly;

public class ProductsOutput {
	
	private List<PrettyProductOnly> products;
	
	public ProductsOutput(List<Product> products) {
		super();
		List<PrettyProductOnly> allPrettyProducts = new ArrayList<PrettyProductOnly>();
		if (products != null) {
			for (Product product : products) {
				PrettyProductOnly prettyProduct = new PrettyProductOnly(product);
				allPrettyProducts.add(prettyProduct);
			}
		}
		
		this.products = allPrettyProducts;
	}


	public List<PrettyProductOnly> getProjects() {
		return products;
	}

	
}
