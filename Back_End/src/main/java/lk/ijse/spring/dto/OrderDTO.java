package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String orderId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    private CustomerDTO customer;
    private double cost;
    private int discount;
    List<OrderDetailDTO> orderDetail;

}
