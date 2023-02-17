package com.cropdeal.farmerservice.model;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JavaBean
@Document(collection="Crop")
public class Crop {
    @Id
	private String id;
	private String cropName;
	private String cropType;
	private String cropQuantity;
	private List<Location> location;
	private String price;
	private String uploadedBy;
	
	public Crop()
	{
		
	}

	public Crop(String id, String cropName, String cropType, String cropQuantity, List<Location> location,
			String price, String uploadedBy) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.cropType = cropType;
		this.cropQuantity = cropQuantity;
		this.location = location;
		this.price = price;
		this.uploadedBy = uploadedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getCropQuantity() {
		return cropQuantity;
	}

	public void setCropQuantity(String cropQuantity) {
		this.cropQuantity = cropQuantity;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", cropName=" + cropName + ", cropType=" + cropType + ", cropQuantity=" + cropQuantity
				+ ", location=" + location + ", price=" + price + ", uploadedBy=" + uploadedBy + "]";
	}
	
	
	

}