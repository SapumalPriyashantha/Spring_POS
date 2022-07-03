package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchItem(@PathVariable String id){
        return new ResponseUtil(200, "Ok", itemService.searchItem(id));
    }

    @GetMapping(path = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItems() {
        return new ResponseUtil(200, "GetAll", itemService.getAllItems());
    }

    @GetMapping(path = "getAllIds",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItemIds(){
        return new ResponseUtil(200, "GetAll", itemService.getAllItemIds());
    }

    @GetMapping(path = "count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil itemCount(){
        return new ResponseUtil(200, "Count", itemService.itemCount());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveItem(@ModelAttribute ItemDTO item) {
        itemService.saveItem(item);
        return new ResponseUtil(200, "Save", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateItem(@RequestBody ItemDTO item) {
        itemService.updateItem(item);
        return new ResponseUtil(200, "Update", null);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return new ResponseUtil(200, "Delete", null);
    }


}
