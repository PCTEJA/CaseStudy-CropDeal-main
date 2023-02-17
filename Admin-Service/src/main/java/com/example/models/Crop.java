package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Crop")
public class Crop {
	@Id
	private String id;
	private String cropName;
	private String cropType;
	private String cropQuantity;
	private Location location;
	private String uploadedBy;
	private String price;
	
	public Crop(String id, String cropName, String cropType, String cropQuantity,
			Location location, String uploadedBy, String price) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.cropType = cropType;
		this.cropQuantity = cropQuantity;
		this.location = location;
		this.uploadedBy = uploadedBy;
		this.price = price;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", cropName=" + cropName + ", cropType=" + cropType + ", cropQuantity=" + cropQuantity
				+ ", location=" + location + ", uploadedBy=" + uploadedBy + ", price=" + price + "]";
	}
	
	

	

}
