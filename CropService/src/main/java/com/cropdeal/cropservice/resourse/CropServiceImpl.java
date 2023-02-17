package com.cropdeal.cropservice.resourse;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.repository.CropRepository;
@Service
public class CropServiceImpl implements CropService{

	@Autowired
	CropRepository cropRepository;
	
	public List<Crop> findAll() {
		return cropRepository.findAll();
	}
	
	public Optional<Crop> getCropById(String id) {
		return cropRepository.findById(id);
	}

	public Crop addCrop(Crop crop) {
	return cropRepository.insert(crop);
	}
	
	public Crop updateCrop(Crop crop) { 
		return cropRepository.save(crop);
		}

	public String deleteById(String id) {
		 cropRepository.deleteById(id);
		return null;
	}
}
