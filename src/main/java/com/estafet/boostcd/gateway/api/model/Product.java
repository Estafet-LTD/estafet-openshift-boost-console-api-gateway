package com.estafet.boostcd.gateway.api.model;

public class Product {

    private String productId;
    private String description;
    private String version;
    private String repo;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }
    
    public static class ProductBuilder {

        private String productId;
        private String description;
        private String version;
        private String repo;

		public ProductBuilder setRepo(String repo) {
			this.repo = repo;
			return this;
		}

		public ProductBuilder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setVersion(String version) {
            this.version = version;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setDescription(description);
            product.setProductId(productId);
            product.setVersion(version);
            product.setRepo(repo);
            return product;
        }
        
    }

}