package br.com.dbccompany.myshop.dto;

import lombok.Data;

@Data
public class CheckoutDTO {
    private String companyFaker;
    private String addressFaker;
    private String cityFaker;
    private String stateFaker;
    private String zipCodeFaker;
    private String countryFaker;
    private String homePhoneFaker;
    private String cellPhoneFaker;
    private String adtionalInfoFaker;
}
