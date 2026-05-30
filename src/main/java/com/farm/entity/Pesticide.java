package com.farm.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pesticide")
public class Pesticide {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pesticideId;
  private String name;
  private String company;
  private LocalDate purchaseDate;
  private Double price;
  private Double qty; // current stock in grams/ml
  private String unit;
  @Column(columnDefinition="TEXT")
  private String notes;
  public Long getPesticideId() {
	return pesticideId;
  }
  public void setPesticideId(Long pesticideId) {
	this.pesticideId = pesticideId;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getCompany() {
	return company;
  }
  public void setCompany(String company) {
	this.company = company;
  }
  public LocalDate getPurchaseDate() {
	return purchaseDate;
  }
  public void setPurchaseDate(LocalDate purchaseDate) {
	this.purchaseDate = purchaseDate;
  }
  public Double getPrice() {
	return price;
  }
  public void setPrice(Double price) {
	this.price = price;
  }
  public Double getQty() {
	return qty;
  }
  public void setQty(Double qty) {
	this.qty = qty;
  }
  public String getUnit() {
	return unit;
  }
  public void setUnit(String unit) {
	this.unit = unit;
  }
  public String getNotes() {
	return notes;
  }
  public void setNotes(String notes) {
	this.notes = notes;
  }

  // getters & setters
  
  
}
