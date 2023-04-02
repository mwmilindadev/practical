package com.springbootpractical.practical.dto.request;

import com.springbootpractical.practical.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemUpdateDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType mesuaringTypes;
    private double balanceQuantity;
    private double supplierPrice;
    private double seelingPrice;
    private  boolean activeStatus;
}
