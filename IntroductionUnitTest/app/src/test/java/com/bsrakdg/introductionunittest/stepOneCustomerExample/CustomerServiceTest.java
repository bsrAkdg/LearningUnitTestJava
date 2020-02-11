package com.bsrakdg.introductionunittest.stepOneCustomerExample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private InformationHelper informationHelper;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customerService.saveCustomer(customer);

        // We need to control whether saveCustomer called saveCustomer and sendEmailToCustomer
        // methods
        Mockito.verify(customerRepository).saveCustomer(customer);
        Mockito.verify(informationHelper).sendEmailToCustomer(customer);
    }

    @Before
    public void setUp() throws Exception {
        // Prepare needed objects before write test with @Before annotation

        // customerRepository = new CustomerRepository();
        // informationHelper = new InformationHelper();
        // Above codes is dependency for CustomerService, so we use Mockito to remove dependency
        // We need to follow this guide to use Mockito (https://site.mockito.org)
        customerRepository = Mockito.mock(CustomerRepository.class);
        informationHelper = Mockito.mock(InformationHelper.class);

        customerService = new CustomerService();
        customerService.setCustomerRepository(customerRepository);
        customerService.setInformationHelper(informationHelper);
    }
}