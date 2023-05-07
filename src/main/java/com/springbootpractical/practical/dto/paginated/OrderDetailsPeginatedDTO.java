package com.springbootpractical.practical.dto.paginated;

import com.springbootpractical.practical.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsPeginatedDTO {
    List<ResponseOrderDetailsDTO> responseOrderDetailsDTOList;
    private long count;
}
