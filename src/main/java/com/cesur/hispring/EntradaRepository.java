/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cesur.hispring;

import java.util.List;
import models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chris
 */
@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    public List<models.Entrada> findByCategoria (String categoria);
    public List<models.Entrada> findByAutor (String autor);
    @Query (value = "SELECT e.id, e.titulo FROM Entrada e")
    List<Object> idTitulo();
}
