package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO searchOrder(String id);

    String generateId();

    void placeOrder(OrderDTO dto);

    long orderCount();

    void deleteOrder(String id);

    List<OrderDTO> getAllOrders();


}
