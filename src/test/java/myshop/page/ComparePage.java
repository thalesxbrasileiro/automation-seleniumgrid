package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class ComparePage extends Interactions {

	private static final By btnWomen = cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
	private static final By btnAddToCompare1 = cssSelector("#center_column > ul > li:nth-child(1) > div > div.functional-buttons.clearfix > div > a");
	private static final By btnAddToCompare2 = cssSelector("#center_column > ul > li:nth-child(2) > div > div.functional-buttons.clearfix > div > a");
	private static final By btnCompare = cssSelector("#center_column > div.content_sortPagiBar.clearfix > div.top-pagination-content.clearfix > form");
	private static final By fieldProductComparison = cssSelector("#center_column > h1");
	private static final By mouse = cssSelector("#center_column > ul > li:nth-child(1)");
	private static final By mouse2 = cssSelector("#center_column > ul > li:nth-child(2)");
	private static final By btnQuickView = cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.quick-view");
	private static final By modalProduct = cssSelector("#category > div.fancybox-overlay.fancybox-overlay-fixed > div");
	private static final By btnAddToCart = cssSelector("#product_comparison > tbody > tr:nth-child(1) > td.ajax_block_product.comparison_infos.product-block.product-2 > div.comparison_product_infos > div > div > a.button.ajax_add_to_cart_button.btn.btn-default > span");
	private static final By fieldSuccessfullyAdded = cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");
	private static final By btnContinueShopping = cssSelector("#center_column > ul > li > a > span");
	private static final By btnRemove1 = cssSelector("#product_comparison > tbody > tr:nth-child(1) > td.ajax_block_product.comparison_infos.product-block.product-1 > div.remove > a > i");
	private static final By btnRemove2 = cssSelector("#product_comparison > tbody > tr:nth-child(1) > td.ajax_block_product.comparison_infos.product-block.product-2 > div.remove > a > i");
	private static final By fieldCompositions = cssSelector("#product_comparison > tbody > tr:nth-child(2) > td.comparison_feature_odd.comparison_infos.product-1");
	private static final By fieldStyles = cssSelector("#product_comparison > tbody > tr:nth-child(3) > td.comparison_feature_even.comparison_infos.product-1");
	private static final By fieldProperties = cssSelector("#product_comparison > tbody > tr:nth-child(4) > td.comparison_feature_odd.comparison_infos.product-1");

	public String comparePage() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		clickable(btnAddToCompare1);
		Thread.sleep(5000);
		hoverOverElement(mouse2);
		clickable(btnAddToCompare2);
		click(btnCompare);

		return readText(fieldProductComparison);
	}

	public void quickViewButton() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		click(btnQuickView);
		Thread.sleep(2000);
		readText(modalProduct);
	}

	public void addToCart() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		clickable(btnAddToCompare1);
		Thread.sleep(2000);
		hoverOverElement(mouse2);
		clickable(btnAddToCompare2);
		click(btnCompare);
		click(btnAddToCart);
		readText(fieldSuccessfullyAdded);
	}

	public void continueShopping() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		clickable(btnAddToCompare1);
		Thread.sleep(2000);
		hoverOverElement(mouse2);
		clickable(btnAddToCompare2);
		click(btnCompare);
		click(btnContinueShopping);
	}

	public void detailsOfTheProducts() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		clickable(btnAddToCompare1);
		Thread.sleep(2000);
		hoverOverElement(mouse2);
		clickable(btnAddToCompare2);
		click(btnCompare);
		readText(fieldCompositions);
		readText(fieldStyles);
		readText(fieldProperties);
	}

	public void removeProductOfComparition() throws InterruptedException {
		click(btnWomen);
		hoverOverElement(mouse);
		clickable(btnAddToCompare1);
		Thread.sleep(5000);
		hoverOverElement(mouse2);
		clickable(btnAddToCompare2);
		click(btnCompare);
		click(btnRemove1);
		click(btnRemove2);
	}

}
