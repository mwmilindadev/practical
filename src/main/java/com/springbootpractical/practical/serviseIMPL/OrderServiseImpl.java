package com.springbootpractical.practical.serviseIMPL;

import com.springbootpractical.practical.dto.paginated.OrderDetailsPeginatedDTO;
import com.springbootpractical.practical.dto.queryinterface.OrderDetailsInterface;
import com.springbootpractical.practical.dto.request.RequestOrderSaveDTO;
import com.springbootpractical.practical.dto.response.ResponseOrderDetailsDTO;
import com.springbootpractical.practical.entity.Customar;
import com.springbootpractical.practical.entity.OrderDetails;
import com.springbootpractical.practical.entity.Orders;
import com.springbootpractical.practical.repository.CustomarRepository;
import com.springbootpractical.practical.repository.ItemRepository;
import com.springbootpractical.practical.repository.OderDetailsRepository;
import com.springbootpractical.practical.repository.OrderRepository;
import com.springbootpractical.practical.servise.OrderSevise;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiseImpl implements OrderSevise {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OderDetailsRepository oderDetailsRepository;

    @Autowired
    private CustomarRepository customarRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO) {

        System.out.println("requestOrderSaveDTO.getCustomar()"+requestOrderSaveDTO.getCustomar());
        //Customar customar=customarRepository.getReferenceById(requestOrderSaveDTO.getCustomar());
        //System.out.println("fgfgg"+customar);
        Orders orders= new Orders(
                customarRepository.getReferenceById(requestOrderSaveDTO.getCustomar()),
                                  requestOrderSaveDTO.getDate(),
                                  requestOrderSaveDTO.getTotal()
        );

        orderRepository.save(orders);
        //System.out.println("orders.getOrderId()"+orders.getOrderId());
        if(orderRepository.existsById(orders.getOrderId())){
            List<OrderDetails> orderDetailsList=modelMapper.map(requestOrderSaveDTO.getOrderDetailsSet(),new TypeToken<List<OrderDetails>>(){}.getType());
            for (int i =0; i<orderDetailsList.size();i++){
                orderDetailsList.get(i).setOrders(orders);
                orderDetailsList.get(i).setItems(itemRepository.getReferenceById(requestOrderSaveDTO.getOrderDetailsSet().get(i).getItems()));


            }
            if(orderDetailsList.size()>0){
                oderDetailsRepository.saveAll(orderDetailsList);
            }
        }

        return "saved";
    }

    @Override
    public OrderDetailsPeginatedDTO getAllStateOrderDetails(boolean satus, int page, int size) {
        List<OrderDetailsInterface> list=orderRepository.getAllOrderDetails(satus, PageRequest.of(page, size));
        List<ResponseOrderDetailsDTO>detailsDTOS=modelMapper.map(list,new TypeToken<List<ResponseOrderDetailsDTO>>(){}.getType());
        OrderDetailsPeginatedDTO orderDetailsPeginatedDTO=new OrderDetailsPeginatedDTO(detailsDTOS,orderRepository.countAllDetails(satus));
        return orderDetailsPeginatedDTO;
    }

}
