package br.com.restaurant.model;

public class Restaurant {

	private String id;

	private String name;
	private String category;
	private String deliveryEstimate;
	private Double rating;
	private String imagePath;
	private String about;
	private String hours;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDeliveryEstimate() {
		return deliveryEstimate;
	}

	public void setDeliveryEstimate(String deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

}
