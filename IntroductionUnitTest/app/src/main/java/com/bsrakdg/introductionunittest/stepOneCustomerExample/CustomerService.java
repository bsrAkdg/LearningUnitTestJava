package com.bsrakdg.introductionunittest.stepOneCustomerExample;

/**
 * Test will be written to this class
 */
public class CustomerService {

    private CustomerRepository customerRepository;
    private InformationHelper informationHelper;

    // Test will be written to this method
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
        informationHelper.sendEmailToCustomer(customer);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setInformationHelper(InformationHelper informationHelper) {
        this.informationHelper = informationHelper;
    }
}
