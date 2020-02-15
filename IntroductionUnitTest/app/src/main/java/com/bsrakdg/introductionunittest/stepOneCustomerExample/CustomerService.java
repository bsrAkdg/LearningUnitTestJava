package com.bsrakdg.introductionunittest.stepOneCustomerExample;

import com.bsrakdg.introductionunittest.common.CustomerRepository;
import com.bsrakdg.introductionunittest.common.InformationHelper;
import com.bsrakdg.introductionunittest.stepNineAssertJ.Gift;
import com.bsrakdg.introductionunittest.stepOneCustomerExample.Customer;

/**
 * Test will be written to this class
 */
public class CustomerService {

    private CustomerRepository customerRepository;
    private InformationHelper informationHelper;

    public void clear() {
        customerRepository.clear();
    }

    // Test will be written to this method
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
        informationHelper.sendEmailToCustomer(customer);
    }

    public void removeCustomer(Integer customerId) {
        customerRepository.removeCustomer(customerId);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setInformationHelper(InformationHelper informationHelper) {
        this.informationHelper = informationHelper;
    }

    public Customer handleNewCustomer(String username, String email) {
        Customer customer = new Customer(username, email);

        giveWelcomeGifts(customer);

        customerRepository.saveCustomer(customer);
        informationHelper.sendWelcomeEmail(customer);
        return customer;
    }

    private void giveWelcomeGifts(Customer customer) {
        customer.addGift(new Gift("1 Welcome " + customer.getUsername()));
        customer.addGift(new Gift("2 Welcome " + customer.getUsername()));
    }
}
