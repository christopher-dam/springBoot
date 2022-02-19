/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */

@Data
@Service
@Entity
@Table(name="blog")
public class Entrada implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private String contenido;
    private String categoria;
    private Date fecha;
    private int ISBN;
    private String edicion;
    
}
