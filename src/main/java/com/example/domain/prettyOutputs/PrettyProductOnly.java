package com.example.domain.prettyOutputs;

import com.example.domain.Product;
import com.google.gson.Gson;

public class PrettyProductOnly {
	
	private Long productId;
	private String productName;
	
	public PrettyProductOnly(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
	}
	
	
	
	public Long getProductId() {
		return productId;
	}



	public String getProductName() {
		return productName;
	}



	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}

}
