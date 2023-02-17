package com.cropdeal.farmerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cropdeal.farmerservice.model.Farmer;
import com.cropdeal.farmerservice.Exception.FarmerNotFoundException;
import com.cropdeal.farmerservice.controller.FarmerController;
import com.cropdeal.farmerservice.repository.FarmerRepository;
import com.cropdeal.farmerservice.service.FarmerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FarmerServiceApplicationTests {

	@Autowired
    private FarmerServiceImpl service;
    @MockBean
     private FarmerRepository farmerrepo;

	
	
	@Test
    public void getFarmerTest() {
        when(farmerrepo.findAll()).thenReturn(Stream
                .of(new Farmer("123","abcd","abc@123","34567889", null,null),
                        new Farmer("321","cba","cba@321","34567889", null,null))
                .collect(Collectors.toList()));
        assertEquals(2, service.findAll().size());
    }

    @Test
    public void getfarmerByIdTest() throws FarmerNotFoundException {
        String id= "321";
        try {
            service.getFarmerById(id); 
        }
        catch(FarmerNotFoundException e) 
        {
            System.out.println(e);
        }


    }



    @Test
    public void addfarmerTest() {
        Farmer farmer = new Farmer("1","abc","abc@gmail.com","12412414",null,null);
        when(farmerrepo.insert(farmer)).thenReturn(farmer);
        Farmer res=service.addFarmer(farmer);
        System.out.println(res);
    }



    
	@Test
    public void deleteFarmerbyidTest() {
        Farmer farmer = new Farmer("999", "def","def@33", "234567",null,null);
        String id = "3";
        service.deleteById(id);
        verify(farmerrepo, times(1)).deleteById(id);
    }



}
