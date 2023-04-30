package com.springbootpractical.practical.controller;

import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.paginated.CustomarPeginatedDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;
import com.springbootpractical.practical.servise.CustomarServise;
import com.springbootpractical.practical.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customar")
@CrossOrigin
public class CustomarController {

    @Autowired
    private CustomarServise customarServise;

    @PostMapping("/save")
    public String  saveCustomar(@RequestBody CustomarDTO customarDTO){
        String message=customarServise.saveCustomar(customarDTO);
        return  message;
    }

    @PutMapping("/update")
    public String updateCustomar(@RequestBody CustomarUpdateDTO customarUpdateDTO){
        String updateMessage=customarServise.updateCustomar(customarUpdateDTO);
        return updateMessage;

    }

    @DeleteMapping(path = "/delete-customar",
    params = "id")
    public String deleteCustomar(@RequestParam(value = "id") int customarId){
        String message=customarServise.deleteCustomar(customarId);
        return  message;

    }


    @GetMapping(path = "/get-custor-by-id",
    params ="id" )
    public CustomarDTO getCustomarById(@RequestParam(value = "id") int customarId){

        CustomarDTO customarDTO=customarServise.getCustomarById(customarId);
        return customarDTO;


    }

    @GetMapping(path = "/get-customar-all")
    public List<CustomarDTO> getAllCustomars(){
        List<CustomarDTO> customarDTOList=customarServise.getAllCustomars();
        return customarDTOList;

    }

    @GetMapping(path = "get-customar-by-city/{city}/{name}")
    public List<CustomarDTO> getCustomarByCityAndName(@PathVariable(value = "city") String cityName,@PathVariable(value = "name")String customarName){
           List<CustomarDTO>customarDTOList=customarServise.getCustomarByCityAndName(cityName,customarName);
           return customarDTOList;
    }

     @GetMapping(path = "/get-peginated-y-status",
                 params = {"status","page","size"})

    public ResponseEntity<StandardResponse> getPeginatedData(
            @RequestParam(value = "status") boolean status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50)int size
     ) throws ClassNotFoundException {
         CustomarPeginatedDTO customarPeginatedDTO=customarServise.getAllPeginated(status,page,size);
         return new ResponseEntity<StandardResponse>(new StandardResponse(200,"ok",customarPeginatedDTO), HttpStatus.OK);

     }






}
