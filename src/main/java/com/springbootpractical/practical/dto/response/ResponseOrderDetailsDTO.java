package com.springbootpractical.practical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //customar
    private String customarName;
    private  String customarAddress;
    private ArrayList contactNo;
    //order
    private Date date;
    private Double total;
}
