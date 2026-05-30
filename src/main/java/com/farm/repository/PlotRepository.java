package com.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farm.entity.Plot;

public interface PlotRepository extends JpaRepository<Plot, Long> { 
	  // Custom query method to get all plots belonging to a crop
    List<Plot> findByCrop_CropId(Long cropId);
}