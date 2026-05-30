package com.farm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.entity.Crop;
import com.farm.repository.CropRepository;

import java.util.List;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Crop getCropById(Long id) {
        return cropRepository.findById(id).orElse(null);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}
