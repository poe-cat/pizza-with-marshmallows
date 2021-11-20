package com.poecat.marshmallowtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private Date placedAt;

    @NotBlank(message = "The name field cannot be empty.")
    private String deliveryName;

    @NotBlank(message = "The street field cannot be empty.")
    private String deliveryStreet;

    @NotBlank(message = "The city field cannot be empty.")
    private String deliveryCity;

    @NotBlank(message = "The state field cannot be empty.")
    private String deliveryState;

    @NotBlank(message = "The zip code field cannot be empty.")
    private String deliveryZip;

    @CreditCardNumber(message = "Invalid card number.")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Correct date form: MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV code")
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addDesign(Pizza design) {
        this.pizzas.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
