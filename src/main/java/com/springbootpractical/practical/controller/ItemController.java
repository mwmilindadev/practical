package com.springbootpractical.practical.controller;

import com.springbootpractical.practical.dto.ItemDTO;
import com.springbootpractical.practical.dto.request.ItemUpdateDTO;
import com.springbootpractical.practical.dto.response.ItemRespoanceDTO;
import com.springbootpractical.practical.servise.ItemServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-v1-item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemServise itemServise;

    @PostMapping("/save")
    public  String saveItem(@RequestBody ItemDTO itemDTO){
        String message=itemServise.saveItem(itemDTO);
        return message;

    }

    @PutMapping("/update")
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message=itemServise.updateItem(itemUpdateDTO);
        return message;

    }

    @DeleteMapping(path = "delete-item-by-id",
    params = "id")
    public String deleteItem(@RequestParam(name = "id")int itemId){
        String message=itemServise.deleteitemById(itemId);
        return message;

    }

    @GetMapping(path = "get-item-by-id/{id}")
    public ItemRespoanceDTO getItemById(@PathVariable(name = "id")int itemId){

        ItemRespoanceDTO itemRespoanceDTO=itemServise.getItemById(itemId);
        return  itemRespoanceDTO;
    }

    @GetMapping(path = "get-all-items")
    public List<ItemRespoanceDTO> getAllItems(){
        List<ItemRespoanceDTO>itemRespoanceDTOS=itemServise.getAllItems();
        return itemRespoanceDTOS;
    }

    @GetMapping(path = "get-item-balanceqty/{qty}")
    public List<ItemRespoanceDTO>getQtyList(@PathVariable(name = "qty") double balanceQty){
        List<ItemRespoanceDTO>itemRespoanceDTOS=itemServise.getAllBalanceQty(balanceQty);
        return itemRespoanceDTOS;

    }

}
