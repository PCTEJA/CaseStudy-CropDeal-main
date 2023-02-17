package com.example.controller;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.example.models.Admin;
import com.example.models.Crop;
import com.example.models.Dealer;
import com.example.models.Farmer;
import com.example.service.AdminService;


@RestController
@RequestMapping("/Admin")
public class AdminController {

	Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	AdminService adminservice;

	@GetMapping("/findadmins")
	
	public List<Admin> getadmin() {
		log.info("All admins are viewed");
		return adminservice.findAll();
	}

	@GetMapping("/getAdminById/{id}")
	public Optional<Admin> getadminById(@PathVariable String id) {
		log.info(" admin based on id is viewed");
		return adminservice.getAdminById(id);
	}

	@PostMapping("/addadmin")
	@PreAuthorize("hasRole('ADMIN')")
	public Admin addadmin(@RequestBody Admin admin) {
		log.info(" New admin details are added");
		return adminservice.addAdmin(admin);
	}

	@PutMapping("/updateadmin")
	public Admin updateadmin(@RequestBody Admin admin) {
		log.info("admin details are updated");
		return adminservice.updateAdmin(admin);
	}

	@DeleteMapping("/deleteadmin/{id}")
	public String deleteadmin(@PathVariable String id) {
		log.info("Deleted admin based on id");
		adminservice.deleteById(id);
		return "admin deleted having id " + id;
	}

	@GetMapping("/admin/get/crop")
	public List<Object> getCropatAdmin() {
		log.info("farmer can have a look of the available crops");
		Object[] crop = restTemp.getForObject("http://cropservice/crop/findcrops", Object[].class);
		return Arrays.asList(crop);
	}

	@GetMapping("/admin/get/crop/{id}")
	public Crop getCropatAdminbyID(@PathVariable("id") String id) {
		log.info("farmer can get a particular crop");
		Crop crop = restTemp.getForObject("http://cropservice/crop/getCropById/" + id, Crop.class);
		return crop;

	}

	@GetMapping("/admin/get/farmer")
	public List<Object> getFarmeratAdmin() {
		log.info("admin can have a look of all farmers");
		Object[] farmer = restTemp.getForObject("http://farmerservice/farmer/findfarmers", Object[].class);
		return Arrays.asList(farmer);
	}

	@GetMapping("/admin/get/farmer/{id}")
	public Farmer getFarmeratAdminbyID(@PathVariable("id") String id) {
		log.info("admin can get a particular farmer");
		Farmer farmer = restTemp.getForObject("http://farmerservice/farmer/getFarmerById/" + id, Farmer.class);
		return farmer;
	}

	@RequestMapping(value = "/admin/delete/farmer/{id}", method = RequestMethod.DELETE)
	public String deleteFarmerById(@PathVariable("id") String id) {
		log.info("admin deleted the farmer he want to remove ");
		return restTemp
				.exchange("http://farmerservice/farmer/deletefarmer/" + id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}

	@GetMapping("/admin/get/dealer")
	public List<Object> getDealeratAdmin() {
		log.info("admin can have a look of all dealers");
		Object[] dealer = restTemp.getForObject("http://dealerservice/dealer/finddealer", Object[].class);
		return Arrays.asList(dealer);
	}

	@GetMapping("/admin/get/dealer/{id}")
	public Dealer getDealeratAdminbyID(@PathVariable("id") String id) {
		log.info("admin can get a particular dealer");
		Dealer dealer = restTemp.getForObject("http://dealerservice/dealer/getDealerById/" + id, Dealer.class);
		return dealer;
	}

	@RequestMapping(value = "/admin/delete/dealer/{id}", method = RequestMethod.DELETE)
	public String deleteDealerById(@PathVariable("id") String id) {
		log.info("admin deleted the dealer he want to remove ");
		return restTemp
				.exchange("http://dealerservice/dealer/deletedealer/" + id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}

}
