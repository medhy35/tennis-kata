package projet.esiea.model;

import projet.esiea.model.entitiesMarket.Product;
import projet.esiea.model.entitiesReceipt.SupermarketCatalog;

import java.util.HashMap;
import java.util.Map;

public class FakeCatalog implements SupermarketCatalog {
	private Map<String, Product> products = new HashMap<>();
	private Map<String, Double> prices = new HashMap<>();

	@Override
	public void addProduct(Product product, double price) {
        this.products.put(product.getName(), product);
        this.prices.put(product.getName(), price);
    }

	@Override
	public void removeProduct(String name) {
		prices.remove(name);
		products.remove(name);
	}
	@Override
    public double getUnitPrice(Product p) {
        return this.prices.get(p.getName());
    }

	@Override
	public Map<String, Product> getProducts() {
		return products;
	}

	@Override
	public Map<String, Double> getPrices() {
		return prices;
	}
}
