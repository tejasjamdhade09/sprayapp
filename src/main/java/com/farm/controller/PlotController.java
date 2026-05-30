package com.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.farm.entity.Plot;
import com.farm.Services.PlotService;
import com.farm.repository.CropRepository;

@Controller
@RequestMapping("/plot")
public class PlotController {

    @Autowired
    private PlotService plotService;

    @Autowired
    private CropRepository cropRepository;

    // ✅ List all plots
    @GetMapping("/list")
    public String listPlots(Model model) {
        model.addAttribute("plots", plotService.getAllPlots());
        model.addAttribute("crops", cropRepository.findAll());
        return "plot/list"; // templates/plot/list.html
    }

    // ✅ Show add form
    @GetMapping("/add")
    public String addPlotForm(Model model) {
        model.addAttribute("plot", new Plot());
        model.addAttribute("crops", cropRepository.findAll());
        return "plot/add"; // templates/plot/add.html
    }

    // ✅ Save plot
    @PostMapping("/save")
    public String savePlot(@ModelAttribute("plot") Plot plot) {
        plotService.savePlot(plot);
        return "redirect:/plot/list";
    }

    // ✅ Edit form
    @GetMapping("/edit/{id}")
    public String editPlot(@PathVariable Long id, Model model) {
        model.addAttribute("plot", plotService.getPlotById(id));
        model.addAttribute("crops", cropRepository.findAll());
        return "plot/edit"; // templates/plot/edit.html
    }

    // ✅ Delete plot
    @GetMapping("/delete/{id}")
    public String deletePlot(@PathVariable Long id) {
        plotService.deletePlot(id);
        return "redirect:/plot/list";
    }
}
