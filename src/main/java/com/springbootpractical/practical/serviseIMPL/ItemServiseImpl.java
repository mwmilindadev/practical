package com.springbootpractical.practical.serviseIMPL;

import com.springbootpractical.practical.dto.ItemDTO;
import com.springbootpractical.practical.dto.paginated.ItemPeginatedDTO;
import com.springbootpractical.practical.dto.request.ItemUpdateDTO;
import com.springbootpractical.practical.dto.response.ItemRespoanceDTO;
import com.springbootpractical.practical.entity.Item;
import com.springbootpractical.practical.repository.ItemRepository;
import com.springbootpractical.practical.servise.ItemServise;
import com.springbootpractical.practical.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiseImpl implements ItemServise {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        //Item item=modelMapper.map(itemDTO,Item.class);
        Item item=itemMapper.dtoToItem(itemDTO);
        if(!itemRepository.existsById(item.getItemId())){
            itemRepository.save(item);
            return itemDTO.getItemName() + "Saved";
        }else{
            throw new DuplicateKeyException("Already Added");
        }

    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepository.existsById(itemUpdateDTO.getItemId())){
            //Item item=modelMapper.map(itemUpdateDTO,Item.class);
            Item item=itemMapper.updateDtoToItem(itemUpdateDTO);
            itemRepository.save(item);
            return itemUpdateDTO.getItemId()+ "Updated";

        }else{
            throw new RuntimeException("No Data Found");
        }

    }

    @Override
    public String deleteitemById(int itemId) {
        if(itemRepository.existsById(itemId)){
           itemRepository.deleteById(itemId);
           return itemId + "Deleted";

        }else{
            throw new RuntimeException("NoData Found");
        }

    }

    @Override
    public ItemRespoanceDTO getItemById(int itemId) {
        if(itemRepository.existsById(itemId)){
            Item item=itemRepository.getReferenceById(itemId);
            //ItemRespoanceDTO itemRespoanceDTO=modelMapper.map(item,ItemRespoanceDTO.class);
            ItemRespoanceDTO itemRespoanceDTO=itemMapper.entityToDto(item);
            return itemRespoanceDTO;

        }else{
            throw new RuntimeException("No Data Found");
        }

    }

    @Override
    public List<ItemRespoanceDTO> getAllItems() {
        List<Item>itemList=itemRepository.findAll();
        if(itemList.size()>0){
            //List<ItemRespoanceDTO>itemRespoanceDTOS=modelMapper.map(itemList,new TypeToken<List<Item>>(){}.getType());
            List<ItemRespoanceDTO> itemRespoanceDTOS=itemMapper.entityListToDtoList(itemList);
            return itemRespoanceDTOS;
        }else{
            throw new RuntimeException("No Data Found");

        }

    }

    @Override
    public List<ItemRespoanceDTO> getAllBalanceQty(double balanceQty) {
        List<Item>itemList=itemRepository.findAllByBalanceQuantityEquals(balanceQty);
        if(itemList.size()>0){
            List<ItemRespoanceDTO> itemRespoanceDTOS=modelMapper.map(itemList,new TypeToken<List<ItemRespoanceDTO>>(){}.getType());
            //List<ItemRespoanceDTO> itemRespoanceDTOS=itemMapper.entityListToDtoList(itemList);
            return  itemRespoanceDTOS;
        }else{
            throw new RuntimeException("No Data Fond");
        }

    }

    @Override
    public ItemPeginatedDTO finAllStatusPeginated(boolean activeStatus, int page, int size) {
        Page<Item>itemPage=itemRepository.findAllByActiveStatusEquals(activeStatus, PageRequest.of(page, size));
        if(itemPage.getSize()<1){
            throw new RuntimeException("NotFound");

        }
        ItemPeginatedDTO itemPeginatedDTO = new ItemPeginatedDTO(
        itemMapper.pageToDto(itemPage),
                itemRepository.countAllByActiveStatusEquals(activeStatus)
        );
        return itemPeginatedDTO;
    }
}
