package com.springbootpractical.practical.dto.queryinterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
     String getCustomarName();
     String getCustomarAddress();
     ArrayList getContactNo();
    //order
     Date getDate();
     Double getTotal();
}
