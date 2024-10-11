package myshop.test;

import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.CartPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.CartStory.*;

public class CartTest extends BaseTest{

    Validation validation = new Validation();
    CartPage cartPage = new CartPage();

    @Test(description = CE_COMPARE_01)
    public void addProductToCart() throws InterruptedException {
        cartPage.addToCart();
    }

    @Test(description = CE_COMPARE_02)
    public void deleteProd() throws InterruptedException {
        cartPage.addToCart();
        cartPage.deleteToCart();

        String message = cartPage.msgDeleteProd();
        validation.textValidation(message, "Your shopping cart is empty.");
    }

    @Test(description = CE_COMPARE_03)
    public void removeOneProductFromCart() throws InterruptedException {
        cartPage.addToCart();
        cartPage.removeAProduct();

        String qtd = cartPage.validateQuantityProdsInCart();
        validation.textValidation("1", qtd);

        String price = cartPage.validatePrice();
        validation.textValidation(price, "$34");
    }

    @Test(description = CE_COMPARE_04)
    public void AddOneProductFromCart() throws InterruptedException {
        cartPage.addToCart();
        cartPage.addAProduct();

        String qtd = cartPage.validateQuantityProdsInCart();
        validation.textValidation("3", qtd);

        String price = cartPage.validatePrice();
        validation.textValidation(price, "$88");
    }

    @Test(description = CE_COMPARE_05)
    public void returnToShopping() throws InterruptedException {
        cartPage.addToCart();
        cartPage.returnToShopping();
    }

}