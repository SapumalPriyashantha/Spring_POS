package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public OrderDTO searchOrder(String id) {
        if (orderRepo.existsById(id)) {
            return mapper.map(orderRepo.findById(id).get(), OrderDTO.class);
        } else {
            throw new RuntimeException("No Order For " + id);
        }
    }

    @Override
    public String generateId() {
        String id = orderRepo.generateId();
        if (!(id == null)) {
            int tempId = Integer.parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "OID-00" + tempId;

            } else if (tempId <= 99) {
                return "OID-0" + tempId;

            } else {
                return "OID-" + tempId;
            }
        } else {
            return "OID-001";
        }
    }

    @Override
    public void placeOrder(OrderDTO dto) {
        System.out.println(dto.toString());

        Orders orders = mapper.map(dto, Orders.class);
        System.out.println(orders);

        if (!orderRepo.existsById(dto.getOrderId())) {
            orderRepo.save(orders);

            for (OrderDetail detail : orders.getOrderDetail()) {
                System.out.println("haree");
                Item item = itemRepo.findById(detail.getItemCode()).get();
                item.setQty(item.getQty() - detail.getQty());
                itemRepo.save(item);
            }
        } else {
            throw new RuntimeException("Place order Failed,Try Again..!");
        }
    }

    @Override
    public long orderCount() {
        return orderRepo.count();
    }

    @Override
    public void deleteOrder(String id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Order ID.. No Such Order..!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return mapper.map(orderRepo.findAll(), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }
}
