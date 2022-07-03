package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private int itemQty;

}
