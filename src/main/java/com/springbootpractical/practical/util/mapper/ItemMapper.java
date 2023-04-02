package com.springbootpractical.practical.util.mapper;

import com.springbootpractical.practical.dto.ItemDTO;
import com.springbootpractical.practical.dto.request.ItemUpdateDTO;
import com.springbootpractical.practical.dto.response.ItemRespoanceDTO;
import com.springbootpractical.practical.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item dtoToItem(ItemDTO itemDTO);
    Item updateDtoToItem(ItemUpdateDTO itemUpdateDTO);

    List<ItemRespoanceDTO> entityListToDtoList(List<Item> itemList);

    ItemRespoanceDTO entityToDto(Item item);
}
