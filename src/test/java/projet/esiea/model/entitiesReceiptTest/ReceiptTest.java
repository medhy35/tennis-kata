package projet.esiea.model.entitiesReceiptTest;


import org.junit.jupiter.api.Test;
import projet.esiea.model.FakeCatalog;
import projet.esiea.model.entitiesMarket.Discount;
import projet.esiea.model.entitiesMarket.Product;
import projet.esiea.model.entitiesMarket.ProductUnit;
import projet.esiea.model.entitiesReceipt.Receipt;
import projet.esiea.model.entitiesReceipt.ShoppingCart;
import projet.esiea.model.entitiesReceipt.SupermarketCatalog;
import projet.esiea.model.entitiesReceipt.Teller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class ReceiptTest {

	public Receipt creationOfOneReceipt() {
		SupermarketCatalog catalog = new FakeCatalog();
		Product toothbrush = new Product("toothbrush", ProductUnit.Each);
		catalog.addProduct(toothbrush, 0.99);
		Product apples = new Product("apples", ProductUnit.Kilo);
		catalog.addProduct(apples, 1.99);

		ShoppingCart cart = new ShoppingCart();
		cart.addItemQuantity(apples, 2.5);
		cart.addItemQuantity(toothbrush, 3);

		Teller teller = new Teller(catalog);

		Receipt receipt = teller.checksOutArticlesFrom(cart);

		Discount discountApples = new Discount(apples, "Add discount on product", 0.995);
		Discount discountToothbrush = new Discount(toothbrush, "Add Discount toothbrush", 0.99);
		receipt.addDiscount(discountApples);

		return receipt;
	}

	@Test
	public void testingForAddingProductInTheReceipt() {
		Receipt receipt = creationOfOneReceipt();
		final int expectedSizeOfReceiptItem = 2;
		int actualSizeOfArrayListReceiptItem = 0;
		for (int i = 0; i < receipt.getItems().size(); i++) {
			actualSizeOfArrayListReceiptItem++;
		}

		try {
			assertThat(expectedSizeOfReceiptItem).isEqualTo(actualSizeOfArrayListReceiptItem);
		} catch (RuntimeException e) {
			fail("Fail to add product in receipt");
		}

	}


}
