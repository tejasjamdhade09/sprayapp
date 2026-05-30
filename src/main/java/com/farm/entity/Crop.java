package com.farm.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "crop")
public class Crop {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "crop_id")  
  private Long cropId;
  private String name;
  @Column(columnDefinition = "TEXT")
  private String notes;
  public Long getCropId() {
	return cropId;
  }
  public void setCropId(Long cropId) {
	this.cropId = cropId;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getNotes() {
	return notes;
  }
  public void setNotes(String notes) {
	this.notes = notes;
  }

  // getters & setters
  
}
