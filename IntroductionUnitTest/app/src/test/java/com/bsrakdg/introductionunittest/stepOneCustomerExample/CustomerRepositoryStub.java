package com.bsrakdg.introductionunittest.stepOneCustomerExample;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryStub extends CustomerRepository {

    private Map<Integer, Customer> customerList = new HashMap<>();

    @Override
    public void saveCustomer(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void removeCustomer(Integer customerId) {
        customerList.remove(customerId);
    }

    public Map<Integer, Customer> getCustomerList() {
        return customerList;
    }

}
