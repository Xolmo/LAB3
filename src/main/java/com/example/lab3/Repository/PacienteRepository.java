package com.example.lab3.Repository;

import com.example.lab3.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query(value = "SELECT * FROM paciente p WHERE p.hospital_id = ?1",
            nativeQuery = true)
    List<Paciente> obtenerPacientesPorHospital(Integer id);

    @Query(value = "SELECT * FROM paciente p where p.doctor_id = ?1", nativeQuery = true)
    List<Paciente> obtenerPacientesPorDoctor(int doctor_id);
}
