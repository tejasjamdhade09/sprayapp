package com.farm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.farm.Services.PesticideService;
import com.farm.entity.Pesticide;


@Controller
@RequestMapping("/pesticide")
public class PesticideController {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("pesticides", pesticideService.listAll());
        return "pesticide/list"; // points to templates/pesticide/list.html
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("pesticide", new Pesticide());
        return "pesticide/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Pesticide pesticide) {
        pesticideService.save(pesticide);
        return "redirect:/pesticide/list";
    }
}
