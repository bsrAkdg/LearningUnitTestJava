package com.bsrakdg.introductionunittest.stepNineAssertJ;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertJComplexListTest {

    @Test
    public void testExtractPropertyWithTupleCustomerListError() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ayşe"));
        customerList.add(new Customer(2, "Fatma"));
        customerList.add(new Customer(3, "Hayriye"));
        customerList.add(new Customer(4, "Ali"));

        // Which field and Which class (Integer), must include every containsExactly items
        assertThat(extractProperty("id", Integer.class).from(customerList))
                .containsExactly(1, 2, 3);
    }

    @Test
    public void testExtractPropertyWithTupleCustomerListSuccess() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ayşe"));
        customerList.add(new Customer(2, "Fatma"));
        customerList.add(new Customer(3, "Hayriye"));
        customerList.add(new Customer(4, "Ali"));

        // Which field and Which class (Integer), must include every containsExactly items
        assertThat(extractProperty("id", Integer.class).from(customerList))
                .containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testExtractingCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ayşe"));
        customerList.add(new Customer(2, "Fatma"));
        customerList.add(new Customer(3, "Hayriye"));
        customerList.add(new Customer(4, "Ali"));

        // look each name and matched inside value by "customerName"
        assertThat(customerList)
                .extracting("customerName")
                .contains("Ayşe", "Fatma");
    }

    @Test
    public void testExtractingWithTupleCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ayşe"));
        customerList.add(new Customer(2, "Fatma"));
        customerList.add(new Customer(3, "Hayriye"));
        customerList.add(new Customer(4, "Ali"));

        // look each name and matched inside value by "customerName" and "id" with tuple(multiple)
        assertThat(customerList)
                .extracting("customerName", "id")
                .contains( // order is important : first item must be customerName
                        tuple("Ayşe", 1),
                        tuple("Hayriye", 3)
                );
    }

}