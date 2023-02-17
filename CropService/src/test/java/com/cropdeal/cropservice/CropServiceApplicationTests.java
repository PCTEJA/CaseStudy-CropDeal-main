package com.cropdeal.cropservice;

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

import com.cropdeal.cropservice.controller.CropController;
import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.repository.CropRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
class CropServiceApplicationTests 
{

	@Autowired
	private CropController service;
	

	@MockBean
	private CropRepository croprepo;
	
	@Test
	void addcropTest() {
		Crop crop = new Crop("111","abcc","organic","5kg",null,"500","Xavier");
		when(croprepo.save(crop)).thenReturn(crop); 
		Crop res =service.addcrop(crop);
		//assertEquals(crop.getId(),res.getId());
	}
	@Test
	 void getCropTest() {
		when(croprepo.findAll()).thenReturn(Stream.of(new Crop("123","abcd","organic","3kg", null,"700","Xavier"),
				new Crop("321","cba","organic","6kg", null,"600","Xavier"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getcrop().size()); 

	}
	
	

	@Test
	 void deleteCropbyidTest() {
		Crop crop = new Crop("123","abcd","organic","3kg", null,"700","Xavier");
		service.deletecrop("123");
		verify(croprepo, times(1)).deleteById("123");
	}

	
	
	
	@Test
	 void getCropByIdTest() {
		String id="2"; 
		service.getcropById(id);
	    verify(croprepo).findById(id); 
	}

}
