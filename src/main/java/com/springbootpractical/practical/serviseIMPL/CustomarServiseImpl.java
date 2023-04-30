package com.springbootpractical.practical.serviseIMPL;

import com.springbootpractical.practical.configuration.ModelMapperConfigurations;
import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.paginated.CustomarPeginatedDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;
import com.springbootpractical.practical.entity.Customar;
import com.springbootpractical.practical.repository.CustomarRepository;
import com.springbootpractical.practical.servise.CustomarServise;
import com.springbootpractical.practical.util.mapper.CustomarMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomarServiseImpl implements CustomarServise {

    @Autowired
    private CustomarRepository customarRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CustomarMapper customarMapper;
    @Override
    public String saveCustomar(CustomarDTO customarDTO) {
        //Customar customar=modelMapper.map(customarDTO,Customar.class);//modelmapper
        Customar customar=customarMapper.dtoToCustomarSave(customarDTO);//mapstruct
        customarRepository.save(customar);
        return customarDTO.getCustomarName() + "Saved Success.";
    }

    @Override
    public String updateCustomar(CustomarUpdateDTO customarUpdateDTO) {
        if(customarRepository.existsById(customarUpdateDTO.getCustomarId())){

            //Customar customar = modelMapper.map(customarUpdateDTO,Customar.class);//modelmapper
            Customar customar = customarMapper.dtoToCustoma(customarUpdateDTO);//mapstruct
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
            //CustomarDTO customarDTO = modelMapper.map(customar,CustomarDTO.class);//modelmapper
            CustomarDTO customarDTO =customarMapper.customarEnityToDto(customar);//mapstruct
            return customarDTO;

        }else{
            throw new RuntimeException("No data found");
        }

    }

    @Override
    public List<CustomarDTO> getAllCustomars() {

        List<Customar> customarList=customarRepository.findAll();
        if(customarList.size()>0){

            //List<CustomarDTO>customarDTOList=modelMapper.map(customarList,new TypeToken<List<CustomarDTO>>(){}.getType());//modelmapper
            List<CustomarDTO>customarDTOList=customarMapper.customarEntityListToDtoList(customarList);//mapstruct
            return customarDTOList;
        }else{
            throw new RuntimeException("No data found");
        }


    }

    @Override
    public String deleteCustomar(int customarId) {
        if(customarRepository.existsById(customarId)){
            customarRepository.deleteById(customarId);
            return customarId + "Deleted";

        }else{
            throw new RuntimeException("No data found");
        }


    }

    @Override
    public List<CustomarDTO> getCustomarByCityAndName(String cityName, String customarName) {
        List<Customar> customarList=customarRepository.findAllByCustomarAddressEqualsAndCustomarNameEquals(cityName,customarName);
        if(customarList.size()>0) {
            //List<CustomarDTO> customarDTOList = customarMapper.customarEntityListToDtoList(customarList);//modelmapper
            List<CustomarDTO>customarDTOList=modelMapper.map(customarList,new TypeToken<List<CustomarDTO>>(){}.getType());//mapstruct
            return customarDTOList;
        }else{
            throw new RuntimeException("No Data found");
        }

    }

    @Override
    public CustomarPeginatedDTO getAllPeginated(boolean status, int page, int size) throws ClassNotFoundException {

        Page<Customar>customarPage=customarRepository.findAllByActivateStatusEquals(status, PageRequest.of(page,size));
         if(customarPage.getSize()<1){
             throw new ClassNotFoundException("no");
         }
         CustomarPeginatedDTO customarPeginatedDTO=new CustomarPeginatedDTO(
                 customarMapper.pageToDto(customarPage),
                 customarRepository.countAllByActivateStatusEquals(status)

         );

        return customarPeginatedDTO;
    }

}
