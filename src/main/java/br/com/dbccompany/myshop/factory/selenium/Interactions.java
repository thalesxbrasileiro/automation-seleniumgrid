package br.com.dbccompany.myshop.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static br.com.dbccompany.myshop.factory.selenium.Waits.*;

public class Interactions extends Elements {

    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    protected static void clickVisibility(By by) {
        visibilityElement(by);
        element(by).click();
    }

    protected static void clickable(By by) {
        elementToClickable(by);
        element(by).click();
    }

    protected static String readText(By by) {
        waitElement(by);
        return element(by).getText();
    }

	protected static void sendKeys(By by, Keys key) {
		waitElement(by);
		element(by).sendKeys(key);
	}

	protected static void hoverOverElement(By by) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element(by)).perform();
	}


    protected static String readAttribute(By by, String attribute) {
        elementToClickable(by);
        return element(by).getAttribute(attribute);
    }
}
