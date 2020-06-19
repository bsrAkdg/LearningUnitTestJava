package com.bsrakdg.introductionunittest.stepElevenCustomOwnAsserts;

import com.bsrakdg.introductionunittest.common.CustomerRepository;
import com.bsrakdg.introductionunittest.common.InformationHelper;
import com.bsrakdg.introductionunittest.stepElevenCustomOwnAsserts.custom.CustomerAssert;
import com.bsrakdg.introductionunittest.stepOneCustomerExample.Customer;
import com.bsrakdg.introductionunittest.stepOneCustomerExample.CustomerService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CustomOwnAssertsTest {

    private CustomerRepository customerRepository;
    private InformationHelper informationHelper;
    private CustomerService customerService;

    public static final String USERNAME = "Okan";
    public static final String EMAIL = "okan@blabla.com";

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
        customerRepository = Mockito.mock(CustomerRepository.class);
        informationHelper = Mockito.mock(InformationHelper.class);

        customerService.setCustomerRepository(customerRepository);
        customerService.setInformationHelper(informationHelper);
    }

    @Test
    public void testCustomerAssert() {
        Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);

        //Firstly check called methods to use verify
        Mockito.verify(customerRepository).saveCustomer(customer);
        // or use Mockito.any
        Mockito.verify(customerRepository).saveCustomer(Mockito.any(Customer.class));
        Mockito.verify(informationHelper).sendWelcomeEmail(customer);

        // so check gift count
        Assert.assertNotNull(customer.getGifts());
        Assert.assertEquals(2, customer.getGifts().size());
        Assert.assertEquals("1 Welcome " + customer.getUsername(), customer.getGifts().get(0).getName());
        Assert.assertEquals("2 Welcome " + customer.getUsername(), customer.getGifts().get(1).getName());
    }

    @Test
    public void testCustomAssert() {
        Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
        // assertThatCustomer(customer). // you can access all assert methods

        // We can create own assert methods with assertThatCustomer
        assertThatCustomer(customer)
                .hasGift(2)
                .hasGiftWithName("1 Welcome " + USERNAME)
                .hasGiftWithName("2 Welcome " + USERNAME);

    }

    @Test
    public void testCustomAssertWithMock() {
        Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
        // assertThatCustomer(customer). // you can access all assert methods

        // We can create own assert methods with assertThatCustomer
        assertThatCustomer(customer)
                .isSaved()
                .hasReceivedEmail()
                .hasGift(2)
                .hasGiftWithName("1 Welcome " + USERNAME)
                .hasGiftWithName("2 Welcome " + USERNAME);

    }

    private CustomerAssert assertThatCustomer(Customer customer) {
        return new CustomerAssert(customer, CustomerAssert.class, customerRepository, informationHelper);
    }
}