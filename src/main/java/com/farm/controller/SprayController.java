package com.farm.controller;

import com.farm.entity.*;
import com.farm.Services.*;
import com.farm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/spray")
public class SprayController {

    @Autowired private SprayService sprayService;
    @Autowired private PlotRepository plotRepository;
    @Autowired private PesticideRepository pesticideRepository;
    @Autowired private SprayRecordRepository sprayRecordRepository;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("sprays", sprayRecordRepository.findAll());
        return "spray/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("plots", plotRepository.findAll());
        model.addAttribute("pesticides", pesticideRepository.findAll());
        return "spray/add";
    }
    
    @PostMapping("/add")
    public String saveSpray(
            @RequestParam Long plotId,
            @RequestParam String sprayDate,
            @RequestParam Double water,
            @RequestParam List<Long> pesticideIds,
            @RequestParam List<Double> sprayQty
    ) {
        SprayRecord record = new SprayRecord();
        record.setPlot(plotRepository.findById(plotId).orElse(null));
        record.setSprayDate(LocalDate.parse(sprayDate));
        record.setWaterUsed(water);

        List<SprayPesticide> uses = new ArrayList<>();
        for (int i = 0; i < pesticideIds.size(); i++) {
            SprayPesticide sp = new SprayPesticide();
            sp.setPesticide(pesticideRepository.findById(pesticideIds.get(i)).orElse(null));
            sp.setSprayedQty(sprayQty.get(i));
            sp.setSprayRecord(record);
            uses.add(sp);
        }
        record.setPesticideUses(uses);

        sprayService.saveSpray(record);
        return "redirect:/spray/list";
    }
}
