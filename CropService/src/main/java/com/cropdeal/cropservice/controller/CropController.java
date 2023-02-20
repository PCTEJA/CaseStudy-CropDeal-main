package com.cropdeal.cropservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.resourse.CropServiceImpl;

@RestController
@RequestMapping("/crop")
@CrossOrigin(origins = "http://localhost:4200")
public class CropController 
{
	Logger log = LoggerFactory.getLogger(CropController.class);

	@Autowired
	CropServiceImpl cropserviceimpl; 
	
	@GetMapping("/findcrops")
	public List<Crop> getcrop() 
	{
		log.info("The available crops are viewed successfully");
		return cropserviceimpl.findAll();
	}
	
	@GetMapping("/getCropById/{id}")
	public Optional<Crop> getcropById(@PathVariable String id)
	{
		log.info("The crop" +id+ "found");
		return cropserviceimpl.getCropById(id);
	}
	  
	  @PostMapping("/addcrop")
		public Crop addcrop(@RequestBody Crop crop) {
		  log.info("Crop added successfully");
			return 	cropserviceimpl.addCrop(crop);
		}
	  
	  @PutMapping("/updatecrop")
	 
	  public Crop updateCrop(@RequestBody Crop crop) 
	  {
		  log.info("Crop updated successfully");
		  return cropserviceimpl.updateCrop(crop); 
	  }
	  
	  @DeleteMapping("/deletecrop/{id}")
		public String deletecrop(@PathVariable String id) 
	  {
		 cropserviceimpl.deleteById(id);
		 log.info("Crop"+id+"deleted successfully");
	    return "crop deleted having id " + id;
		}
}
