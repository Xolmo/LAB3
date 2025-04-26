package com.example.lab3.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "id")
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
