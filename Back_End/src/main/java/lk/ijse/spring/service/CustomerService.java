package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO searchCustomer(String id);

    void saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    List<CustomerDTO> getAllCustomers();

    List<String> getAllCustomerIds();

    long customerCount();

}
