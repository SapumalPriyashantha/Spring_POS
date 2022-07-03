package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", customerService.searchCustomer(id));
    }

    @GetMapping(path = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "GetAll", customerService.getAllCustomers());
    }

    @GetMapping(path = "getAllIds",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomerIds(){
        return new ResponseUtil(200, "GetAll", customerService.getAllCustomerIds());
    }

    @GetMapping(path = "count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil customerCount(){
        return new ResponseUtil(200, "Count", customerService.customerCount());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer) {
        customerService.saveCustomer(customer);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
        return new ResponseUtil(200, "Update", null);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200, "Delete", null);
    }


}
