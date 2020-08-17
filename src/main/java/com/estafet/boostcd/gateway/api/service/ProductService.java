package com.estafet.boostcd.gateway.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.boostcd.gateway.api.model.Product;
import com.estafet.boostcd.gateway.api.util.ENV;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	public Product getProduct(String product) {
		return restTemplate.getForObject(ENV.ENVIRONMENT_SERVICE_API + "/product/{product}", Product.class, product);
	}

	public List<Product> getProducts() {
		return Arrays.asList(restTemplate.getForObject(ENV.ENVIRONMENT_SERVICE_API + "/products", Product[].class));
	}

	public Product update(Product product) {
		return restTemplate.postForObject(ENV.ENVIRONMENT_SERVICE_API + "/product", product, Product.class);
	}

	public void delete(String product) {
		restTemplate.delete(ENV.ENVIRONMENT_SERVICE_API + "/product/{product}", product);
	}
	
}
