package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class CartPage extends Interactions {

    private static final By btnBestSellers = cssSelector("#home-page-tabs > li:nth-child(2) > a");
    private static final By btnMore = cssSelector("#blockbestsellers > li:nth-child(1) > div > div.right-block > h5 > a");
    private static final By selectSize = cssSelector("#group_1 > option[value=\"2\"]");
    private static final By selectColor = cssSelector("#color_to_pick_list > li:nth-child(1) > a");
    private static final By btnMoreQuantity = cssSelector("#quantity_wanted_p > a:nth-child(4)");
    private static final By btnAddCart = cssSelector("#add_to_cart > button");
    private static final By proceedToCheckout = cssSelector(".button-container > a");

    private static final By btnDelete = cssSelector("#product_2_10_0_0 > td:nth-child(6) > div");
    private static final By msgCartEmpty = cssSelector("#center_column > p");
    private static final By quantityProdsInCart = cssSelector("#product_2_10_0_0 > td:nth-child(5) > input:nth-child(2)");
    private static final By btnLessQuantityInCart = cssSelector("#product_2_10_0_0 > td:nth-child(5) > div > a:first-child");
    private static final By btnMoreQuantityInCart = cssSelector("#product_2_10_0_0 > td:nth-child(5) > div > a:nth-child(2)");
    private static final By totalPrice = cssSelector("#total_price");
    private static final By returnToShopping = cssSelector("#center_column > p.cart_navigation.clearfix > a.button-exclusive.btn.btn-default");

    public void addToCart() throws InterruptedException{
        click(btnBestSellers);
        click(btnMore);
        click(selectSize);
		Thread.sleep(2000);
		click(selectColor);
		readText(btnMoreQuantity);
		Thread.sleep(3000);
        clickable(btnMoreQuantity);
        clickVisibility(btnAddCart);
        readText(proceedToCheckout);
        Thread.sleep(3000);
        click(proceedToCheckout);
    }

    public void deleteToCart() throws InterruptedException{
        readText(btnDelete);
        Thread.sleep(3000);
        clickable(btnDelete);
		Thread.sleep(2000);
    }

    public void removeAProduct() {
        readText(btnLessQuantityInCart);
        clickable(btnLessQuantityInCart);
    }

    public void addAProduct() throws InterruptedException {
        readText(btnMoreQuantityInCart);
        Thread.sleep(3000);
        clickable(btnMoreQuantityInCart);
    }

    public String msgDeleteProd() {
        return readText(msgCartEmpty);
    }

    public String validateQuantityProdsInCart() throws InterruptedException{
        Thread.sleep(2000);
        return readAttribute(quantityProdsInCart, "value");
    }

    public String validatePrice(){
        return readText(totalPrice);
    }

    public void returnToShopping(){
        click(returnToShopping);
    }

}
