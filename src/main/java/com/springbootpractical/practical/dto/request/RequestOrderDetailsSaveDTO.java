package com.springbootpractical.practical.dto.request;


import com.springbootpractical.practical.entity.Item;
import com.springbootpractical.practical.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {


    private String itemName;
    private double qty;
    private Double amount;
    private int orders;
    private int items;
}
