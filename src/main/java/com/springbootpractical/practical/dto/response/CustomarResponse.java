package com.springbootpractical.practical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomarResponse {
    private  int customarId;
    private String customarName;
    private  String customarAddress;
    private double customarSalary;
    private ArrayList contactNo;
    private String nic;
    private boolean activateStatus;
}
