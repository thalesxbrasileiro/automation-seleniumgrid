package myshop.test;

import br.com.dbccompany.myshop.dto.RegisterDto;
import br.com.dbccompany.myshop.factory.data.RegisterData;
import br.com.dbccompany.myshop.factory.selenium.Validation;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import myshop.page.RegisterPage;
import org.testng.annotations.Test;

import static br.com.dbccompany.myshop.storys.RegisterStory.*;

@Epic(EPIC)
@Story(USER_STORY)
public class RegisterTest extends BaseTest {

    RegisterData registerData = new RegisterData();
    RegisterPage registerPage = new RegisterPage();
    Validation validation = new Validation();


    @Test
    @Description(CE_REGISTER_01)
    public void testRegisterUser(){

        RegisterDto user = registerData.validRegister();
        registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());

        String message = registerPage.validationTextConfirmationSingUp();
        validation.textValidation(message, "Your account has been created.");
    }

    @Test
    @Description(CE_REGISTER_02)
    public void testRegisterWithoutName(){

        RegisterDto user = registerData.validRegister();
        registerPage.register(user.getEmail(), "", user.getLastName(), user.getPassword());

        String message = registerPage.validationErrorMessage();
        validation.textValidation(message, "firstname is required.");
    }

    @Test
    @Description(CE_REGISTER_03)
    public void testRegisterWithoutLastName(){

        RegisterDto user = registerData.validRegister();
        registerPage.register(user.getEmail(), user.getFirstName(), "", user.getPassword());

        String message = registerPage.validationErrorMessage();
        validation.textValidation(message, "lastname is required.");
    }

    @Test
    @Description(CE_REGISTER_04)
    public void testRegisterWithInvalidEmail(){

        registerPage.emailInvalid("invalid.com");

        String message = registerPage.validationErrorMessageEmail();
        validation.textValidation(message, "Invalid email address.");
    }

    @Test
    @Description(CE_REGISTER_05)
    public void testRegisterLessThenFiveCharacters(){

        RegisterDto user = registerData.validRegister();
        registerPage.register(user.getEmail(), user.getFirstName(), user.getLastName(), "1234");

        String message = registerPage.validationErrorMessage();
        validation.textValidation(message, "passwd is invalid.");
    }

}
