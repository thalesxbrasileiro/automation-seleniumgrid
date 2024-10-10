package br.com.dbccompany.myshop.factory.selenium;

import org.testng.Assert;

public class Validation {

    public void textValidation(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
}
