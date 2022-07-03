package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepo extends JpaRepository<Orders,String> {

    @Query(value = "select o.orderId from Orders o order by o.orderId desc limit 1",nativeQuery = true)
    String generateId();
}
