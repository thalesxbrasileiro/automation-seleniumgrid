package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.RegisterDto;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class RegisterData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public RegisterDto validRegister(){

        RegisterDto registerDto = new RegisterDto();

        registerDto.setFirstName(dataFakerGenerator.firstName());
        registerDto.setLastName(dataFakerGenerator.lastName());
        registerDto.setEmail(dataFakerGenerator.emailFaker());
        registerDto.setPassword(dataFakerGenerator.passwordFaker());

        return registerDto;
    };
}
