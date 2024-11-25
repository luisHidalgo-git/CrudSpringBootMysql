package com.example.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@Entity
@Table(name="individuo")
public class Individuo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_individuo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String edad;
}
