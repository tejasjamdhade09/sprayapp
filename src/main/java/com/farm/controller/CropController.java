package com.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.farm.entity.Crop;
import com.farm.Services.CropService;
import com.farm.repository.PlotRepository;

@Controller
@RequestMapping("/crop")
public class CropController {

    @Autowired
    private CropService cropService;

    @Autowired
    private PlotRepository plotRepository;

    // ✅ List all crops
    @GetMapping("/list")
    public String listCrops(Model model) {
        model.addAttribute("crops", cropService.getAllCrops());
        return "crop/list";  // points to templates/crop/list.html
    }

    // ✅ Show add crop form
    @GetMapping("/add")
    public String addCropForm(Model model) {
        model.addAttribute("crop", new Crop());
        return "crop/add"; // templates/crop/add.html
    }

    // ✅ Save crop (for add & edit)
    @PostMapping("/save")
    public String saveCrop(@ModelAttribute("crop") Crop crop) {
        cropService.saveCrop(crop);
        return "redirect:/crop/list";
    }

    // ✅ Edit crop
    @GetMapping("/edit/{id}")
    public String editCrop(@PathVariable Long id, Model model) {
        model.addAttribute("crop", cropService.getCropById(id));
        return "crop/edit"; // templates/crop/edit.html
    }

    // ✅ Delete crop
    @GetMapping("/delete/{id}")
    public String deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return "redirect:/crop/list";
    }

    // ✅ View all plots (optional)
    @GetMapping("/plots")
    public String listPlots(Model model) {
        model.addAttribute("plots", plotRepository.findAll());
        return "plot/list"; // templates/plot/list.html
    }
}
