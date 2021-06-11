package com.casestudy.Cart.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Products {

	@Id
	private String _id;
	private String PName;
	private String Category;
	private String PDesc;
	private int Price;
	private int Quantity;
	private String DealerId;
	private String ImgUrl;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String _id, String pName, String category, String pDesc, int price, int quantity,
			String dealerId, String imgUrl) {
		super();
		this._id = _id;
		PName = pName;
		Category = category;
		PDesc = pDesc;
		Price = price;
		Quantity = quantity;
		DealerId = dealerId;
		ImgUrl = imgUrl;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getPDesc() {
		return PDesc;
	}

	public void setPDesc(String pDesc) {
		PDesc = pDesc;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getDealerId() {
		return DealerId;
	}

	public void setDealerId(String dealerId) {
		DealerId = dealerId;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}

}
