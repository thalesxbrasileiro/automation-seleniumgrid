package myshop.test;

import br.com.dbccompany.myshop.dto.FriendDTO;
import br.com.dbccompany.myshop.factory.data.FriendData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.ProductPage;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static br.com.dbccompany.myshop.storys.ProductStory.*;

public class ProductTest extends BaseTest {

	ProductPage productPage = new ProductPage();
	FriendData friendData = new FriendData();
	Validation validation = new Validation();

	@Test(description = CE_PRODUCT_01)
	public void testProductDetails() {
		productPage.productDetails();
	}

	@Test(description = CE_PRODUCT_02)
	public void testImageViewLargerButton() {
		productPage.isTheImageWillEnlarge();
	}

	@Test(description = CE_PRODUCT_03)
	public void testInStock() throws InterruptedException {
		String message = productPage.inStock();
		validation.textValidation("In stock", message);
	}

	@Test(description = CE_PRODUCT_04)
	public void testOuOfStock() {
		String message = productPage.noStock();
		validation.textValidation("This product is no longer in stock", message);
	}

	@Test(description = CE_PRODUCT_05)
	public void testNotInStockWithThoseAttributes() {
		String message = productPage.noLongerInStockWithThoseAttributes();
		validation.textValidation("This product is no longer in stock with those attributes but is available with others.", message);
	}

	@Test(description = CE_PRODUCT_06)
	public void testSocialMideaButton() {
		ArrayList<String> message = productPage.socialMideaButton();

		validation.textValidation("Tweet", message.get(0));
		validation.textValidation("Share", message.get(1));
		validation.textValidation("Google+", message.get(2));
		validation.textValidation("Pinterest", message.get(3));
	}

	@Test(description = CE_PRODUCT_07)
	public void testSendToAFriend() throws InterruptedException {

		FriendDTO friendDTO = friendData.validFriend();
		String message = productPage.sendProductToAFriend(friendDTO.getName(), friendDTO.getEmail());
		validation.textValidation("Your e-mail has been sent successfully", message);
	}

	@Test(description = CE_PRODUCT_08)
	public void testPrint() {
		String message = productPage.isTheButtonPrintIsVisible();
		validation.textValidation("Print", message);
	}

	@Test(description = CE_PRODUCT_09)
	public void testButtonAddToCart() throws InterruptedException {
		String message = productPage.isAddToCartButtonPresent();
		validation.textValidation("Add to cart", message);
	}

}
