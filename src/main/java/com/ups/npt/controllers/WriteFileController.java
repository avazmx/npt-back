/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ups.npt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.npt.model.GeoService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juancarlos
 */
@RestController
@RequestMapping("/write")
public class WriteFileController {
    
    @PostMapping
    @ResponseBody()
    public boolean writeFile(@RequestBody GeoService geoService) {
        ObjectMapper mapper = new ObjectMapper();
        FileWriter fileW;
        BufferedWriter bw = null;
        try{
            String json = mapper.writeValueAsString(geoService);
            File file= new File("src/main/resources/file.json");
            if (!file.exists()) {
               file.createNewFile();
               fileW= new FileWriter(file);
               fileW.write(json);
               fileW.close();
            }else{
               fileW= new FileWriter(file.getAbsoluteFile(), true);
               fileW.write(","+json);
               fileW.close();
            }
            return true;
        }catch(Exception ex){
            return false;
        }
        
    } 
    
}
