package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;


public class CheckoutPage extends Interactions {

    private  static final By btnProceed = cssSelector(".cart_navigation a:first-child");
    private  static final By fieldCompany = cssSelector("#company");
    private  static final By fieldAddress = cssSelector("#address1");
    private  static final By fieldCity = cssSelector("#city");
    private  static final By fieldState = cssSelector("#id_state");
    private  static final By fieldZip = cssSelector("#postcode");
    private  static final By fieldCountry = cssSelector("#id_country");
    private  static final By fieldHomePhone = cssSelector("#phone");
    private  static final By fieldCellPhone = cssSelector("#phone_mobile");
    private  static final By fieldAdditionalInfo = cssSelector("#other");
    private  static final By fieldReference = cssSelector("#alias");
    private  static final By btnSave = cssSelector("#submitAddress");
    private static final By btnHome =  cssSelector("#header_logo");
    private static final By comment =  cssSelector("#ordermsg textarea");
    private static final By btnProceedCkt =  cssSelector(".cart_navigation button");
    private static final By errorMsg =  cssSelector(".fancybox-overlay p");
    private static final By igree =  cssSelector("#uniform-cgv input");
    private static final By cardPayment =  cssSelector(".bankwire");
    private static final By alerSuccess =  cssSelector(".alert-success");
    private static final By errorMsgAddress =  cssSelector(".alert b");
    private static final By errorMsgAddress2 =  cssSelector(".alert li");


    public void goHome(){
        click(btnHome);
    }


    public void checkout(String company, String address, String city, String state, String zip, String country, String homeNumber, String cellPhone, String info, String commentTxt ) throws InterruptedException {
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
		Thread.sleep(2000);
		sendKeys(comment, commentTxt);
        click(btnProceedCkt);
        click(igree);
        click(btnProceedCkt);
        click(cardPayment);
        click(btnProceedCkt);
    }



    public void checkoutWithoutAddress(String company,String city, String state, String zip, String country, String homeNumber, String cellPhone, String info){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);

    }

    public void checkoutWithoutCity(String company, String address, String state, String zip, String country, String homeNumber, String cellPhone, String info ){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
    }



    public void checkoutWithoutState(String company, String address, String city, String zip, String country, String homeNumber, String cellPhone, String info ){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
    }



    public void checkoutWithoutZip(String company, String address, String city, String state, String country, String homeNumber, String cellPhone, String info ) {
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);

    }

    public void checkoutWithoutNumber(String company, String address, String city, String state, String zip, String country, String info ){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
    }

    public void checkoutWithoutComment(String company, String address, String city, String state, String zip, String country, String homeNumber, String cellPhone, String info ){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
        click(btnProceedCkt);
        click(igree);
        click(btnProceedCkt);
        click(cardPayment);
        click(btnProceedCkt);
    }



    public void checkoutWithoutIgree(String company, String address, String city, String state, String zip, String country, String homeNumber, String cellPhone, String info, String commentTxt ){
        click(btnProceed);
        sendKeys(fieldCompany, company);
        sendKeys(fieldAddress, address);
        sendKeys(fieldCity, city);
        sendKeys(fieldState, state);
        sendKeys(fieldZip, zip);
        sendKeys(fieldCountry, country);
        sendKeys(fieldHomePhone, cellPhone);
        sendKeys(fieldCellPhone, cellPhone);
        sendKeys(fieldAdditionalInfo, info);
        click(fieldReference);
        click(btnSave);
        sendKeys(comment, commentTxt);
        click(btnProceedCkt);
        click(btnProceedCkt);
    }


    public String msgValidationSuccess(){
        return readText(alerSuccess);
    }

    public String msgError(){
        return readText(errorMsgAddress);
    }
    public String msgError2(){
        return readText(errorMsgAddress2);
    }

    public String msgError3(){
        return readText(errorMsg);
    }

}