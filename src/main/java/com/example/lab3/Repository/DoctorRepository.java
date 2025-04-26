package com.example.lab3.Repository;

import com.example.lab3.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "SELECT id, nombre, especialidad, hospital_id FROM doctor d WHERE d.hospital_id = ?1",
            nativeQuery = true)
    List<Doctor> obtenerDoctoresPorHospital(Integer id);
}
