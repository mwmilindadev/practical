package com.springbootpractical.practical.controller;

import com.springbootpractical.practical.dto.CustomarDTO;
import com.springbootpractical.practical.dto.request.CustomarUpdateDTO;
import com.springbootpractical.practical.servise.CustomarServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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




}
