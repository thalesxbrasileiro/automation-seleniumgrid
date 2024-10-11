package br.com.dbccompany.myshop.factory.data;

import br.com.dbccompany.myshop.dto.CheckoutDTO;
import br.com.dbccompany.myshop.utils.DataFakerGenerator;

public class CheckoutData {

DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public CheckoutDTO validCheckout(){
        CheckoutDTO checkoutDTO = new CheckoutDTO();

        checkoutDTO.setAddressFaker(dataFakerGenerator.address());
        checkoutDTO.setCompanyFaker(dataFakerGenerator.company());
        checkoutDTO.setCityFaker(dataFakerGenerator.city());
        checkoutDTO.setStateFaker(dataFakerGenerator.state());
        checkoutDTO.setZipCodeFaker(dataFakerGenerator.zipCode());
        checkoutDTO.setCountryFaker(dataFakerGenerator.country());
        checkoutDTO.setHomePhoneFaker(dataFakerGenerator.homePhone());
        checkoutDTO.setCellPhoneFaker(dataFakerGenerator.cellPhone());
        checkoutDTO.setAdtionalInfoFaker(dataFakerGenerator.adtionalInfo());

        return checkoutDTO;
    }
}
