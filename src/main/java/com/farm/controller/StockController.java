package com.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.Services.PesticideService;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping
    public String stockList(Model model) {
        model.addAttribute("lowStockPesticides", pesticideService.findLowStock(5.0)); // Example threshold
        model.addAttribute("allPesticides", pesticideService.listAll());
        return "stock/list";
    }
}
