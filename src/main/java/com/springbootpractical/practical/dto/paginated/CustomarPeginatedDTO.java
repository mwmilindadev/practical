package com.springbootpractical.practical.dto.paginated;

import com.springbootpractical.practical.dto.response.CustomarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomarPeginatedDTO {
    List<CustomarResponse> customarResponses;
    private long count;
}
