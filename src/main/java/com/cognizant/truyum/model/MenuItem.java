package com.cognizant.truyum.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="menu_item")
public class MenuItem {

	public MenuItem(int id, String name, BigDecimal price, String active, Date dateOfLaunch, String category,
			String freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}
	public MenuItem() {		
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="me_id")
	private int id;
	
	@Column(name="me_name")
	private String name;
	
	@Column(name="me_price")
	private BigDecimal price;
	
	@Column(name="me_active")
	private String active;
	
	@Temporal(TemporalType.DATE)
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name="me_category")
	private String category;
	
	@Column(name="me_free_delivery")
	private String freeDelivery;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String isActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", freeDelivery=" + freeDelivery + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
