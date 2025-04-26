package com.example.lab3.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {
    @Id
    @Column(name = "id")
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    private String diagnostico;
    @Column(name = "fecha_cita")
    private LocalDate fechaCita;
    @Column(name = "numero_habitacion")
    private int numHabitacion;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
