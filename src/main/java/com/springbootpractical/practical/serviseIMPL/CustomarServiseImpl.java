package com.springbootpractical.practical.serviseIMPL;

import com.springbootpractical.practical.configuration.ModelMapperConfigurations;
import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;
import com.springbootpractical.practical.entity.Customar;
import com.springbootpractical.practical.repository.CustomarRepository;
import com.springbootpractical.practical.servise.CustomarServise;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomarServiseImpl implements CustomarServise {

    @Autowired
    private CustomarRepository customarRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public String saveCustomar(CustomarDTO customarDTO) {
        Customar customar=modelMapper.map(customarDTO,Customar.class);
        customarRepository.save(customar);
        return customarDTO.getCustomarName() + "Saved Success.";
    }

    @Override
    public String updateCustomar(CustomarUpdateDTO customarUpdateDTO) {
        if(customarRepository.existsById(customarUpdateDTO.getCustomarId())){

            Customar customar = modelMapper.map(customarUpdateDTO,Customar.class);
            customarRepository.save(customar);
            return customarUpdateDTO.getCustomarId()+ "Updated";

        }else{
            throw new RuntimeException("No data found");
        }

    }

    @Override
    public CustomarDTO getCustomarById(int customarId) {
        if(customarRepository.existsById(customarId)){
            Customar customar= customarRepository.getReferenceById(customarId);
            CustomarDTO customarDTO = modelMapper.map(customar,CustomarDTO.class);
            return customarDTO;

        }else{
            throw new RuntimeException("No data found");
        }

    }

    @Override
    public List<CustomarDTO> getAllCustomars() {

        List<Customar> customarList=customarRepository.findAll();
        if(customarList.size()>0){

            List<CustomarDTO>customarDTOList=modelMapper.map(customarList,new TypeToken<List<CustomarDTO>>(){}.getType());
            return customarDTOList;
        }else{
            throw new RuntimeException("No data found");
        }


    }

}
