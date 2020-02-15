package com.bsrakdg.introductionunittest.stepOneCustomerExample;

import com.bsrakdg.introductionunittest.stepNineAssertJ.Gift;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer id;
    private String username;
    private String email;
    private List<Gift> gifts = new ArrayList<>();

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public List<Gift> getGifts() {
        return gifts;
    }

}
