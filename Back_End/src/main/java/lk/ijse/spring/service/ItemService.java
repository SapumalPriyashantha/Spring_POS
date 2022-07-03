package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO searchItem(String id);

    void saveItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String id);

    List<ItemDTO> getAllItems();

    List<String> getAllItemIds();

    long itemCount();


}
