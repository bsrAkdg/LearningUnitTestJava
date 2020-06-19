package com.bsrakdg.introductionunittest.common;

import com.bsrakdg.introductionunittest.stepOneCustomerExample.Customer;

public class CustomerRepository {

    public void clear() {
        System.out.println("Everything was clean");
    }

    public Customer findCustomer(Integer customerId) {
        System.out.println("Customer find");
        return null;
    }

    public void removeCustomer(Integer customerId) {
        System.out.println("Customer removed");
    }

    public void saveCustomer(Customer customer) {
        System.out.println("Customer saved");
    }
}
