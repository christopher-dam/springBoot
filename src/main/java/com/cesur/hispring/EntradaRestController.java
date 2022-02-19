/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesur.hispring;

import java.util.List;
import models.Entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/api")
public class EntradaRestController {
    @Autowired
    private EntradaRepository repo;
    
     @GetMapping (value = "{id}") 
    public Object listarUno (@PathVariable Long id) {
        return repo.findById(id);
    }
    
    @GetMapping ("/categoria/{categoria}") 
    public List<models.Entrada> categoria (@PathVariable String categoria) {
        System.out.println("Obteniendo categoria " + categoria);
        List<models.Entrada> salida = repo.findByCategoria(categoria);
        return salida;
    }
    
    @GetMapping ("/autor/{autor}") 
    public List<models.Entrada> autor (@PathVariable String autor) {
        System.out.println("Obteniendo autor " + autor);
        List<models.Entrada> salida = repo.findByAutor(autor);
        return salida;
    }
    
   @ResponseBody
   @RequestMapping("/idTitulo")
    public List<Object> listarIdTitulo() {
    List<Object> entrada = repo.idTitulo();
    return entrada;
    }
    
    @PostMapping("/")   
    public models.Entrada crear(@ModelAttribute Entrada entrada) {
        return repo.save(entrada);
    }
    
    @PostMapping("/{id}")
    public models.Entrada modificar(@PathVariable Long id, @ModelAttribute Entrada entrada) {
        models.Entrada e = repo.getById(id);
        e.setCategoria( entrada.getCategoria() );
        e.setContenido( entrada.getContenido() );
        e.setTitulo( entrada.getTitulo() );
        e.setAutor( entrada.getAutor() );
        e.setFecha( entrada.getFecha() );
        e.setISBN( entrada.getISBN() );
        e.setEdicion( entrada.getEdicion() );
        return repo.save(e);
    }
    
    @DeleteMapping("/borrar/{id}")
        public ResponseEntity<Void> borrar(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
         
    }
}
