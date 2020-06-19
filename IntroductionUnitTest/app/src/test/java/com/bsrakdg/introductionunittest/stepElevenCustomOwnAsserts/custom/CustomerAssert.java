package com.bsrakdg.introductionunittest.stepElevenCustomOwnAsserts.custom;

import com.bsrakdg.introductionunittest.common.CustomerRepository;
import com.bsrakdg.introductionunittest.common.InformationHelper;
import com.bsrakdg.introductionunittest.stepOneCustomerExample.Customer;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * AbstractAssert base class provides that we can create own assert methods
 */
public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    private CustomerRepository customerRepository;
    private InformationHelper informationHelper;

    public CustomerAssert(Customer customer, Class<?> selfType, CustomerRepository customerRepository, InformationHelper informationHelper) {
        super(customer, selfType);
        this.customerRepository = customerRepository;
        this.informationHelper = informationHelper;
        isNotNull(); // you can add this or after assertThat
    }

    public CustomerAssert hasGift(int size) {
        assertThat(actual.getGifts())
                .hasSize(size);
        return this;
    }

    public CustomerAssert hasGiftWithName(String name) {
        assertThat(actual.getGifts())
                .extracting("name")
                .contains(name);
        return this;
    }

    public CustomerAssert isSaved() {
        Mockito.verify(customerRepository).saveCustomer(Mockito.any(Customer.class));
        return this;
    }

    public CustomerAssert hasReceivedEmail() {
        Mockito.verify(informationHelper).sendWelcomeEmail(Mockito.any(Customer.class));
        return this;
    }
}
