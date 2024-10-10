package myshop.page;

import br.com.dbccompany.myshop.factory.selenium.Interactions;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.openqa.selenium.By.cssSelector;

@NoArgsConstructor
public class RegisterPage extends Interactions {
    private static final By btnSingIn = cssSelector("nav .header_user_info a");
    private static final By fieldGender1 = cssSelector("#id_gender1");
    private static final By fieldGender2 = cssSelector("#id_gender2");
    private static final By fieldEmail = cssSelector("#email_create");
    private static final By btnCreateAnAccount = cssSelector("#SubmitCreate");
    private static final By fieldFirstName = cssSelector("#customer_firstname");
    private static final By fieldLastName = cssSelector("#customer_lastname");
    private static final By fieldPassword = cssSelector("#passwd");
    private static final By btnSubimit = cssSelector("form div.submit button");
    private static final By validationMsg = cssSelector(".center_column p.alert");
    private static final By errorMessage = cssSelector("#center_column .alert ol li");
    private static final By errorMessageEmail = cssSelector("div.alert-danger ol li");


    Faker faker = new Faker();

    public void selecionaDataDeNascimento(LocalDate localDate) {
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        By campoDay = cssSelector("#days > option[value='" + day + "']");
        By campoMonth = cssSelector("#months > option[value='" + month + "']");
        By campoYear = cssSelector("#years > option[value='" + year + "']");

        click(campoDay);
        click(campoMonth);
        click(campoYear);
    }


    public void selecionaGenero(String nomeCompleto) {

        String primeiroNome = nomeCompleto.split(" ")[0];

        if (primeiroNome.endsWith("a") || nomeCompleto.startsWith("Sra.")) {
            click(fieldGender2);
        } else {
            click(fieldGender1);
        }
    }

    public void register(String email, String name, String lastName, String passwrd) {

        Date birthday = faker.date().birthday();
        LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        click(btnSingIn);
        sendKeys(fieldEmail, email);
        click(btnCreateAnAccount);
        selecionaGenero(name);
        sendKeys(fieldFirstName, name);
        sendKeys(fieldLastName, lastName);
        sendKeys(fieldPassword, passwrd);
        selecionaDataDeNascimento(localDate);
        click(btnSubimit);
    }

    public void emailInvalid(String email){
        click(btnSingIn);
        sendKeys(fieldEmail, email);
        click(btnCreateAnAccount);
    }

    public String validationTextConfirmationSingUp() {
        return readText(validationMsg);
    }

    public String validationErrorMessage() {
        return readText(errorMessage);
    }

    public String validationErrorMessageEmail() {
        return readText(errorMessageEmail);
    }

}
