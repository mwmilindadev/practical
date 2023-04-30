package com.springbootpractical.practical.util.mapper;

import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;
import com.springbootpractical.practical.dto.response.CustomarResponse;
import com.springbootpractical.practical.entity.Customar;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomarMapper {
List<CustomarDTO> customarEntityListToDtoList(List<Customar> customarList);
CustomarDTO customarEnityToDto(Customar customar);
List<Customar> dtoListToCustomarList(List<CustomarDTO> customarDTOList);
Customar dtoToCustoma(CustomarUpdateDTO customarDTO);
Customar dtoToCustomarSave(CustomarDTO customarDTO);

List<CustomarResponse> pageToDto(Page<Customar> customarPage);
}
