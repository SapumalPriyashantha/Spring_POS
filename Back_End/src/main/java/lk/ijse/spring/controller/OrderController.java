package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {


    @Autowired
    OrderService orderService;

    @GetMapping(path = "generateId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateId(){
        return new ResponseUtil(200,"Done",orderService.generateId());
    }

    @GetMapping(path = "count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil orderCount(){
        return new ResponseUtil(200,"Done",orderService.orderCount());
    }

    @GetMapping(path = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllOrders(){
        return new ResponseUtil(200,"Save",orderService.getAllOrders()) ;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchOrder(@PathVariable String id){
        return new ResponseUtil(200, "Ok", orderService.searchOrder(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO){
        orderService.placeOrder(orderDTO);
        return new ResponseUtil(200,"Save",null) ;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseUtil(200, "Delete", null);
    }
}
