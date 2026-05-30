package com.farm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.entity.Plot;
import com.farm.repository.PlotRepository;

import java.util.List;

@Service
public class PlotService {

    @Autowired
    private PlotRepository plotRepository;

    public List<Plot> getAllPlots() {
        return plotRepository.findAll();
    }

    public Plot getPlotById(Long id) {
        return plotRepository.findById(id).orElse(null);
    }

    public List<Plot> getPlotsByCropId(Long cropId) {
        return plotRepository.findByCrop_CropId(cropId);
    }

    public Plot savePlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public void deletePlot(Long id) {
        plotRepository.deleteById(id);
    }
}
