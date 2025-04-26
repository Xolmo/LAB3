package com.example.lab3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hospital")
public class Hospital {
    @Id
    @Column(name = "id")
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
}
