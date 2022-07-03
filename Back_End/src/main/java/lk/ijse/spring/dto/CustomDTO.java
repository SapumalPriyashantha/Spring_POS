package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomDTO {
    private String orderId;
    private String custName;
    private String date;
    private int discount;
    private double cost;

}
