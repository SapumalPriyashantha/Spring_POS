package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetail {
    @Id
    private String orderId;
    @Id
    private String itemCode;
    private int qty;
    private double price;

    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "id",insertable = false,updatable = false)
    private Item items;
}
