package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Orders {
    @Id
    private String orderId;
    private String date;
    private double cost;
    private int discount;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId",referencedColumnName = "id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

}
