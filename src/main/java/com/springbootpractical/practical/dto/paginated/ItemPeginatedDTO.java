package com.springbootpractical.practical.dto.paginated;

import com.springbootpractical.practical.dto.response.ItemRespoanceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPeginatedDTO {
    List<ItemRespoanceDTO> itemRespoanceDTOList;
    private long cout;
}
