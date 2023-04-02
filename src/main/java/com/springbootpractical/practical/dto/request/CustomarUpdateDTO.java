package com.springbootpractical.practical.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomarUpdateDTO {
    private  int customarId;
    private String customarName;
    private  String customarAddress;
    private double customarSalary;
    private ArrayList contactNo;
    private String nic;
    private boolean activateStatus;
}

