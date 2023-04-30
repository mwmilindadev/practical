package com.springbootpractical.practical.controller;

import com.springbootpractical.practical.dto.request.RequestOrderSaveDTO;
import com.springbootpractical.practical.repository.OrderRepository;
import com.springbootpractical.practical.servise.OrderSevise;
import com.springbootpractical.practical.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
