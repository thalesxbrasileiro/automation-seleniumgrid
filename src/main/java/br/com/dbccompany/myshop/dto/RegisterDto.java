package br.com.dbccompany.myshop.dto;

import lombok.Data;

@Data
public class RegisterDto {

    public String firstName;
    public String lastName;
    private String email;
    private String password;

}
