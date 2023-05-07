package com.springbootpractical.practical.servise;

import com.springbootpractical.practical.dto.paginated.OrderDetailsPeginatedDTO;
import com.springbootpractical.practical.dto.request.RequestOrderSaveDTO;

public interface OrderSevise {
    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    OrderDetailsPeginatedDTO getAllStateOrderDetails(boolean satus, int page, int size);
}
