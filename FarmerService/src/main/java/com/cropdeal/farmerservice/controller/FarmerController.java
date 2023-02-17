package com.cropdeal.farmerservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.farmerservice.Exception.FarmerNotFoundException;
import com.cropdeal.farmerservice.model.Crop;
import com.cropdeal.farmerservice.model.Farmer;
import com.cropdeal.farmerservice.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	Logger log = LoggerFactory.getLogger(FarmerController.class);
	
	@Autowired
	FarmerService farmerservice; 
	
	@Autowired
	private RestTemplate restTemp;
	
	
	@GetMapping("/findfarmers")
	public List<Farmer> getFarmer() {
		log.info("Farmers found successfully");
    return farmerservice.findAll();
	}
	  	 
	  @GetMapping("/getFarmerById/{id}")
	  public Optional<Farmer> getFarmerById(@PathVariable String id) throws FarmerNotFoundException
	  {
		  log.info("Farmer"+id+"listed");
      return farmerservice.getFarmerById(id); 
	 }
	  
	   @PostMapping("/addfarmer")
		public Farmer addFarmer(@RequestBody Farmer farmer) 
	   {
		   log.info("farmer added successfully");
			return 	farmerservice.addFarmer(farmer);
		}
	  
	  @PutMapping("/updatefarmer") 
	  public Farmer updateFarmer(@RequestBody Farmer farmer) 
	  {
		  log.info("Updated successfully");
		  return farmerservice.updateFarmer(farmer);
      }
	  
	  @DeleteMapping("/deletefarmer/{id}")
		public String deletefarmer(@PathVariable String id) throws FarmerNotFoundException
	  {
		  log.info("deleted"+id+"successfully");
		  farmerservice.deleteById(id);
	    return "farmer deleted having id " + id;
	}
	  
	//---------get all crops----------------------------------------------------//
		@GetMapping("/farmer/getcrop")
		public List<Object> getCropatFarmer() {
			Object[] crop = restTemp.getForObject("http://cropservice/crop/findcrops", Object[].class);
			return Arrays.asList(crop);  
		}
		
		//------------------------------get crops by id-----------------------

		@GetMapping("/farmer/getcrop/{id}")
		public List<Crop> getCropatFarmerbyID(@PathVariable("id") String id) {
			Crop crop = restTemp.getForObject("http://cropservice/crop/getCropById/id" + id, Crop.class);
			return Arrays.asList(crop);
		}
		
		//-------------------------delete the crop by farmer---------------------

		@RequestMapping(value = "/farmer/deletecrop/{id}", method = RequestMethod.DELETE)
		public String deleteCropById(@PathVariable("id") String id) {
			return restTemp.exchange("http://cropservice/crop/deletecrop/{id}" + id, HttpMethod.DELETE, null, String.class)
					.getBody();
		}
		
		//-----------------------------adding crops by farmer---------------

		@RequestMapping(value = "/farmer/addcrop", method = RequestMethod.POST)
		public String addCropatFarmer(@RequestBody Crop crop) {
			HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
			return restTemp.exchange("http://cropservice/crop/addcrop", HttpMethod.POST, entity, String.class).getBody();

		}

		
		//---------------------update the crop by farmer-----------------------------
			@RequestMapping(value="/farmer/update/crop/{id}", method = RequestMethod.PUT)
			public String updateCropatFarmer(@RequestBody Crop crop) {
				HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
				return restTemp.exchange("http://cropservice/crop/updatecrop/", HttpMethod.PUT, entity, String.class).getBody();

			}
			
}

   