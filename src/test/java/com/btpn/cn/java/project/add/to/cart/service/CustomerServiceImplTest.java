package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Customer;
import com.btpn.cn.java.project.add.to.cart.repository.ICustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private ICustomerRepository customerRepository;

    @InjectMocks
    private ICustomerService customerService = new CustomerServiceImpl();

    @Test
    public void saveOrUpdate() {

        Customer customer = new Customer(1, "Dodi", "Jalan Kebagusan 1");

        Customer customerResult = customer;

        Mockito.when(customerService.saveOrUpdate(customer)).thenReturn(customerResult);

        Customer customerReturnFromMock = customerService.saveOrUpdate(customer);

        assertEquals(customerResult, customerReturnFromMock);

    }

    @Ignore
    public void deleteCustomer() {

    }

    @Test
    public void findAllCustomer() {
        Customer customer = new Customer(1, "Dodi", "Jalan Kebagusan 1");
        List<Customer> spiedCustoemrsResult = new ArrayList<Customer>();
        spiedCustoemrsResult.add(customer);

        Mockito.when(customerRepository.findAll()).thenReturn(spiedCustoemrsResult);

        List<Customer> customersReturnFromMock = customerRepository.findAll();

        assertNotNull(spiedCustoemrsResult);
        assertEquals(customersReturnFromMock, spiedCustoemrsResult);
        assertEquals(true, spiedCustoemrsResult.size() > 0);
    }

    @Test
    public void findAllByCustomerName() {
        Customer customer = new Customer(1, "Dodi", "Jalan Kebagusan 1");

        Mockito.when(customerService.findByCustomerId(1)).thenReturn(customer);

        Customer customerReturnFromMock = customerService.findByCustomerId(1);

        assertEquals(customer.getCustomerId(), customerReturnFromMock.getCustomerId());
    }

    @Test
    public void findByCustomerId() {
        Customer customer = new Customer(1, "Dodi", "Jalan Kebagusan 1");

        Mockito.when(customerRepository.getOne(1)).thenReturn(customer);

        Customer customerReturnFromMock = customerRepository.getOne(1);

        assertEquals(customer.getCustomerId(), customerReturnFromMock.getCustomerId());
    }
}