package com.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.farm.entity.SprayPesticide;
import com.farm.repository.SprayPesticideRepository;

@Controller
@RequestMapping("/sprayPesticides")
public class SprayPesticideController {

    @Autowired
    private SprayPesticideRepository sprayPesticideRepository;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        sprayPesticideRepository.deleteById(id);
        return "redirect:/sprays";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SprayPesticide sprayPesticide) {
        sprayPesticideRepository.save(sprayPesticide);
        return "redirect:/sprays";
    }
}
