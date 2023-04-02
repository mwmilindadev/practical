package com.springbootpractical.practical.entity;

import com.springbootpractical.practical.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 500,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type",nullable = false)
    private MeasuringUnitType mesuaringTypes;

    @Column(name = "balance_qty")
    private double balanceQuantity;

    @Column(name = "supplier_price",nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",nullable = false)
    private double seelingPrice;

    @Column(name = "active_status",columnDefinition = "TINYINT Default 0")
    private  boolean activeStatus;




}
