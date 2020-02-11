package com.bsrakdg.introductionunittest.stepOneCustomerExample;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerRepositoryStub customerRepositoryStub;
    private InformationHelper informationHelper;

    @Test
    public void removeCustomer() {
        // add customer existing control
        // don't assertNotNull(customerRepositoryStub.findCustomer(2345));
        // don't call saveCustomerWithStub()
        // add customer with customerService for only remove method testing
        customerService.saveCustomer(new Customer(2345));

        // remove customer with using id
        customerService.removeCustomer(2345);
        // check customer existing, if it is null, removeCustomer is success
        assertNull(customerRepositoryStub.findCustomer(2345));
    }

    @Test
    public void saveCustomerWithMockito() {
        // We use Mockito.verify for testing if depends methods called

        //Testing for saveCustomer on CustomerService methods
        // we should create new customer for addition
        Customer customer = new Customer(1234);
        // Firstly, new customer add CustomerRepository (like real database)
        customerService.saveCustomer(customer);

        // We need to control if saveCustomer called saveCustomer and sendEmailToCustomer methods
        // TODO open below codes when using customerRepository
        // Mockito.verify(customerRepository).saveCustomer(customer);
        // Mockito.verify(informationHelper).sendEmailToCustomer(customer);
    }

    @Test
    public void saveCustomerWithStub() {
        // We create stub repository  for testing,
        // so we should create new CustomerRepositoryStub class extends CustomerRepository.
        // CustomerRepositoryStub class include a customer list
        // and override CustomerRepository methods and return customer list like real database

        //Testing for saveCustomer on CustomerService methods
        // we should create new customer for addition
        Customer customer = new Customer(2345);
        // Firstly, new customer add CustomerRepositoryStub (like real database)
        customerService.saveCustomer(customer);

        // and check repository with using assertion if there is customer
        assertTrue(customerRepositoryStub.getCustomerList().containsValue(customer));
        // or assertNotNull(customerRepositoryStub.getCustomerList().get(customer.getId()));
        // or assertEquals(customer, customerRepositoryStub.getCustomerList().get(customer.getId()));
    }

    @Before
    public void setUp() throws Exception {
        // Prepare needed objects before write test with @Before annotation

        // customerRepository = new CustomerRepository();
        // informationHelper = new InformationHelper();
        // Above codes is dependencies for CustomerService testing
        // so we use Mockito(https://site.mockito.org) or Stub to remove dependencies

        customerRepository = new CustomerRepository();
        customerRepositoryStub = new CustomerRepositoryStub(); // Stub initialization
        informationHelper = Mockito.mock(InformationHelper.class); // Mockito initialization

        customerService = new CustomerService();
        customerService.setInformationHelper(informationHelper);
        customerService.setCustomerRepository(customerRepositoryStub); // saveCustomerWithStub
        // TODO open below codes when using mockito (saveCustomerWithMockito)
        // customerService.setCustomerRepository(customerRepository);

    }

    @After
    public void tearDown() throws Exception {
        // This method called after each method execution
        // It needed run all methods execution, because working order of methods are uncertain
        customerService.clear();
    }
}