/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.cesur.hispring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chris
 */
@Controller
@RequestMapping("/web")
public class EntradaController {
    
    @Autowired
    private EntradaRepository repo;

    @GetMapping("/listar")
    public String main(Model model) {
        model.addAttribute( "entrada", repo.findAll() );
        return "index";
    }
}
