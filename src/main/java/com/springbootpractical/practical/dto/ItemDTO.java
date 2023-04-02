package com.springbootpractical.practical.dto;

import com.springbootpractical.practical.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType mesuaringTypes;
    private double balanceQuantity;
    private double supplierPrice;
    private double seelingPrice;
    private  boolean activeStatus;
}
