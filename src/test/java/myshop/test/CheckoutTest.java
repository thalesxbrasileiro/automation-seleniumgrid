package myshop.test;

import br.com.dbccompany.myshop.dto.CheckoutDTO;
import br.com.dbccompany.myshop.dto.RegisterDto;
import br.com.dbccompany.myshop.factory.data.CheckoutData;
import br.com.dbccompany.myshop.factory.data.RegisterData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import myshop.page.CartPage;
import myshop.page.CheckoutPage;
import myshop.page.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.CheckoutStory.*;

public class CheckoutTest extends BaseTest {

    CheckoutData checkoutData = new CheckoutData();
    CheckoutPage checkoutPage = new CheckoutPage();
    CartPage cartPage = new CartPage();
    RegisterData registerData = new RegisterData();
    RegisterPage registerPage = new RegisterPage();
    Validation validation = new Validation();

    @BeforeMethod
    public void setup() throws InterruptedException{
        RegisterDto user = registerData.validRegister();
        registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());

        checkoutPage.goHome();

        cartPage.addToCart();
    }

    @Test(description = CE_CHECKOUT_01)
    public void testCheckout() throws InterruptedException {

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkout(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getStateFaker(),
                chekInfo.getZipCodeFaker(),
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker(),
                chekInfo.getAdtionalInfoFaker()
                );

        String msg = checkoutPage.msgValidationSuccess();
        validation.textValidation("Your order on My Shop is complete.", msg);
    }


    @Test(description = CE_CHECKOUT_02)
    public void testCheckoutWithoutFillingAddress(){

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutAddress(
                chekInfo.getCompanyFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getStateFaker(),
                chekInfo.getZipCodeFaker(),
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError();
        validation.textValidation("address1", msg);
    }

    @Test(description = CE_CHECKOUT_03)
    public void testCheckoutWithoutFillingCity(){

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutCity(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getZipCodeFaker(),
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError();
        validation.textValidation("city", msg);
    }

    @Test(description = CE_CHECKOUT_04)
    public void testCheckoutWithoutFillingState(){

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutState(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getStateFaker(),
                chekInfo.getZipCodeFaker(),
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError2();
        validation.textValidation("This country requires you to chose a State.", msg);
    }

    @Test(description = CE_CHECKOUT_05)
    public void testCheckoutWithoutFillingZip(){

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutZip(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getStateFaker(),
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError2();
        validation.textValidation("The Zip/Postal code you've entered is invalid. It must follow this format: 00000", msg);
    }

    @Test(description = CE_CHECKOUT_06)
    public void testCheckoutWithoutFillingNumber(){

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutNumber(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getStateFaker(),
                "00000",
                chekInfo.getCountryFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError2();
        validation.textValidation("You must register at least one phone number.", msg);
    }

    @Test(description = CE_CHECKOUT_07)
    public void testCheckoutWithoutFillingComment()  {

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutComment(
                chekInfo.getCompanyFaker(),
                chekInfo.getAddressFaker(),
                chekInfo.getCityFaker(),
                chekInfo.getStateFaker(),
                "00000",
                chekInfo.getCountryFaker(),
                chekInfo.getHomePhoneFaker(),
                chekInfo.getCellPhoneFaker(),
                chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgValidationSuccess();
        validation.textValidation("Your order on My Shop is complete.", msg);
    }

    @Test(description = CE_CHECKOUT_08)
    public void testCheckoutWithoutIgree()  {

        CheckoutDTO chekInfo = checkoutData.validCheckout();
        checkoutPage.checkoutWithoutIgree(
			chekInfo.getCompanyFaker(),
			chekInfo.getAddressFaker(),
			chekInfo.getCityFaker(),
			chekInfo.getStateFaker(),
			"00000",
			chekInfo.getCountryFaker(),
			chekInfo.getHomePhoneFaker(),
			chekInfo.getCellPhoneFaker(),
			chekInfo.getAdtionalInfoFaker(),
			chekInfo.getAdtionalInfoFaker()
        );

        String msg = checkoutPage.msgError3();
        validation.textValidation("You must agree to the terms of service before continuing.", msg);
    }

}
