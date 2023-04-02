package com.springbootpractical.practical.servise;

import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;

import java.util.List;

public interface CustomarServise {
    String saveCustomar(CustomarDTO customarDTO);

    String updateCustomar(CustomarUpdateDTO customarUpdateDTO);

    CustomarDTO getCustomarById(int customarId);

    List<CustomarDTO> getAllCustomars();

    String deleteCustomar(int customarId);

    List<CustomarDTO> getCustomarByCityAndName(String cityName, String customarName);
}
