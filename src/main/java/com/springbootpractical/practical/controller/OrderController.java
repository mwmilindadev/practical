package com.springbootpractical.practical.controller;

import com.springbootpractical.practical.dto.paginated.OrderDetailsPeginatedDTO;
import com.springbootpractical.practical.dto.request.RequestOrderSaveDTO;
import com.springbootpractical.practical.repository.OrderRepository;
import com.springbootpractical.practical.servise.OrderSevise;
import com.springbootpractical.practical.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderSevise orderSevise;

    @PutMapping("/saveOrder")
    public ResponseEntity<StandardResponse> saveTransactionData(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
     String message=orderSevise.saveOrder(requestOrderSaveDTO);
     return  new ResponseEntity<>(new StandardResponse(200,"OK",message), HttpStatus.CREATED);

    }

    @GetMapping(path = "/get-peginated-order-details",
                params = {"statetype","page","size"})
    public ResponseEntity<StandardResponse>getPeginatedOrderDetails(
            @RequestParam (value = "statetype") String stateType,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50)int size)
    {
        OrderDetailsPeginatedDTO peginatedDTO=null;
        if (stateType.equalsIgnoreCase("active")|| stateType.equalsIgnoreCase("inactive")){
            boolean satus=stateType.equalsIgnoreCase("active")?true:false;
            peginatedDTO=orderSevise.getAllStateOrderDetails(satus,page,size);

        }

     return new ResponseEntity<StandardResponse>(new StandardResponse(200,"OK",peginatedDTO),HttpStatus.OK);
    }
}
