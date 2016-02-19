package com.mangopay.demo;

import com.mangopay.MangoPayApi;
import com.mangopay.core.Address;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.CardRegistration;
import com.mangopay.entities.User;
import com.mangopay.entities.UserNatural;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * 19/02/16 09:06
 *
 * @author catalin.craciun
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
@RequestMapping("/")
public class DemoApp extends SpringBootServletInitializer {

    @RequestMapping(value = "/card-registration", method = RequestMethod.GET)
    public CardRegistrationResponse cardRegistration() throws Exception {
        MangoPayApi mangoPayApi = getMangoPayApi();
        User user = mangoPayApi.Users.create(createUser());
        CardRegistration registration = new CardRegistration();
        registration.UserId = user.Id;
        registration.Currency = CurrencyIso.EUR;
        registration = mangoPayApi.CardRegistrations.create(registration);

        CardRegistrationResponse response = new CardRegistrationResponse();
        response.setAccessKey(registration.AccessKey);
        response.setBaseUrl(mangoPayApi.Config.BaseUrl);
        response.setCardPreregistrationId(registration.Id);
        response.setCardRegistrationURL(registration.CardRegistrationURL);
        response.setCardType(registration.CardType.name());
        response.setClientId(mangoPayApi.Config.ClientId);
        response.setPreregistrationData(registration.PreregistrationData);

        return response;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    private MangoPayApi getMangoPayApi() {
        MangoPayApi api = new MangoPayApi();
        api.Config.ClientId = "sdk-unit-tests";
        api.Config.ClientPassword = "cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju";
        return api;
    }

    private User createUser() {
        Calendar c = Calendar.getInstance();
        c.set(1975, Calendar.DECEMBER, 21, 0, 0, 0);

        UserNatural user = new UserNatural();
        user.FirstName = "John";
        user.LastName = "Doe";
        user.Email = "john.doe@sample.org";
        user.Address = this.getNewAddress();
        user.Birthday = c.getTimeInMillis() / 1000;
        user.Nationality = CountryIso.FR;
        user.CountryOfResidence = CountryIso.FR;
        user.Occupation = "programmer";
        user.IncomeRange = 3;
        return user;
    }

    private Address getNewAddress() {
        Address result = new Address();

        result.AddressLine1 = "Address line 1";
        result.AddressLine2 = "Address line 2";
        result.City = "City";
        result.Country = CountryIso.PL;
        result.PostalCode = "11222";
        result.Region = "Region";

        return result;
    }
}
