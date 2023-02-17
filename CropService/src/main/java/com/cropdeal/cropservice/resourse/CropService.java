
package com.cropdeal.cropservice.resourse;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cropdeal.cropservice.model.Crop;

@Service
@Component
public interface CropService {

	
	  public List<Crop> findAll();
	  public Optional<Crop> getCropById(String id);
      public Crop addCrop(Crop crop) ;
   	  public Crop updateCrop(Crop crop);
      public String deleteById(String id);
}      


