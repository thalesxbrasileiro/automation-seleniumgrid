package br.com.dbccompany.myshop.utils;

import net.datafaker.Faker;

public class DataFakerGenerator {

	private static final Faker faker = new Faker();

	public String emailFaker() {
		return faker.internet().emailAddress();
	}

	public String passwordFaker() {
		return faker.internet().password();
	}

	public String firstName() {
		return faker.name().firstName();
	}

	public String lastName() {
		return faker.name().lastName();
	}

	public String orderReference() {
		return faker.commerce().promotionCode();
	}

	public String message() {
		return faker.lorem().paragraph();
	}

	public String blankField() {
		return "";
	}
	public String searchInvalidProd(){
		return faker.code().asin();
	}

	public String company() {
		return faker.company().name();
	}

	public String address() {
		return faker.address().streetAddress();
	}

	public String city() {
		return faker.address().cityName();
	}

	public String state() {
		return faker.address().stateAbbr();
	}

	public String zipCode() {
		return faker.address().zipCode();
	}

	public String country() {
		return faker.address().country();
	}

	public String homePhone() {
		return faker.phoneNumber().cellPhone();
	}

	public String cellPhone() {
		return faker.phoneNumber().cellPhone();
	}

	public String adtionalInfo() {
		return faker.lorem().paragraph();
	}

}
