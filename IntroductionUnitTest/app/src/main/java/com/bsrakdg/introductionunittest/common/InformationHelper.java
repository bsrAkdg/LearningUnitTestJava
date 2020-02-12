package com.bsrakdg.introductionunittest.common;

import com.bsrakdg.introductionunittest.stepOneCustomerExample.Customer;

public class InformationHelper {

    public void sendEmailToCustomer(Customer customer) {
        System.out.println("Send email to customer");
    }

    public void sendEmailWeekly() {
        throw new MailServerUnavailableException("Mail server unavailable");
    }
}
