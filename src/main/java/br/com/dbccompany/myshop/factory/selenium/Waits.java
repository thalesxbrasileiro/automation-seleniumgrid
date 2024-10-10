package br.com.dbccompany.myshop.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Waits extends BrowserService{

    public static void waitElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void visibilityElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void elementToClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
