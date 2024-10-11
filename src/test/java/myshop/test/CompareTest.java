package myshop.test;

import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.ComparePage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.CompareStory.*;

public class CompareTest extends BaseTest {

	ComparePage comparePage = new ComparePage();
	Validation validation = new Validation();

	@Test(description = CE_COMPARE_01)
	public void testComparePage() throws InterruptedException {
		String message = comparePage.comparePage();
		validation.textValidation("PRODUCT COMPARISON", message);
	}

	@Test(description = CE_COMPARE_02)
	public void testQuickView() throws InterruptedException {
		comparePage.quickViewButton();
	}

	@Test(description = CE_COMPARE_03)
	public void testAddToCart() throws InterruptedException {
		comparePage.addToCart();
	}

	@Test(description = CE_COMPARE_04)
	public void testContinueShopping() throws InterruptedException {
		comparePage.continueShopping();
	}

	@Test(description = CE_COMPARE_05)
	public void testDetailsOfProdutcsOnCompare() throws InterruptedException {
		comparePage.detailsOfTheProducts();
	}

	@Test(description = CE_COMPARE_06)
	public void testRemoveButtomOfProductComparison() throws InterruptedException {
		comparePage.removeProductOfComparition();
	}

}
