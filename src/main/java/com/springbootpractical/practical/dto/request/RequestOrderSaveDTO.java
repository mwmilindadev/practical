package com.springbootpractical.practical.dto.request;


import com.springbootpractical.practical.entity.Customar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customar;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetailsSet;


}
