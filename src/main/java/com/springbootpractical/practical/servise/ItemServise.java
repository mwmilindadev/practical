package com.springbootpractical.practical.servise;

import com.springbootpractical.practical.dto.ItemDTO;
import com.springbootpractical.practical.dto.request.ItemUpdateDTO;
import com.springbootpractical.practical.dto.response.ItemRespoanceDTO;

import java.util.List;

public interface ItemServise {
    String saveItem(ItemDTO itemDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    String deleteitemById(int itemId);

    ItemRespoanceDTO getItemById(int itemId);

    List<ItemRespoanceDTO> getAllItems();

    List<ItemRespoanceDTO> getAllBalanceQty(double balanceQty);
}
