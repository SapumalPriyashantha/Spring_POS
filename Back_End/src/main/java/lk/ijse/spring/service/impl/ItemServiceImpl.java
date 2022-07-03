package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ItemDTO searchItem(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), ItemDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id);
        }
    }
    @Override
    public void saveItem(ItemDTO dto) {
        if (!repo.existsById(dto.getItemId())) {
            repo.save(mapper.map(dto, Item.class));
        } else {
            throw new RuntimeException("Item Already Added..!");
        }
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if (repo.existsById(dto.getItemId())) {
            repo.save(mapper.map(dto, Item.class));
        } else {
            throw new RuntimeException("No Such Item To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteItem(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Item ID.. No Such Item..!");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapper.map(repo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public List<String> getAllItemIds() {
        return repo.findAllIds();
    }

    @Override
    public long itemCount(){
        return repo.count();
    }
}
