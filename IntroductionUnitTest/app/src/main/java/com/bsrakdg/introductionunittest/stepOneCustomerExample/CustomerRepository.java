package com.bsrakdg.introductionunittest.stepOneCustomerExample;

public class CustomerRepository {

    public void saveCustomer(Customer customer) {
        System.out.println("Customer saved");
    }

    public void removeCustomer(Integer customerId) {
        System.out.println("Customer removed");
    }
}
