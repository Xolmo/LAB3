package com.example.lab3.Controller;

import com.example.lab3.Entity.Doctor;
import com.example.lab3.Entity.Hospital;
import com.example.lab3.Entity.Paciente;
import com.example.lab3.Repository.DoctorRepository;
import com.example.lab3.Repository.HospitalRepository;
import com.example.lab3.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping(value = {"" , "/"})
    public String listaHospitales(Model model) {
        List<Hospital> hospitales = hospitalRepository.findAll();
        model.addAttribute("hospitales", hospitales);
        return "hospital/list";
    }

    @GetMapping("/doctor")
    public String listaDoctoresEnHospital(Model model, @RequestParam("id") Integer hospitalId) {
        List<Doctor> doctors = doctorRepository.obtenerDoctoresPorHospital(hospitalId);
        model.addAttribute("doctors", doctors);
        return "hospital/doctor";
    }

    @GetMapping("/paciente")
    public String listaPacientesEnHospital(Model model, @RequestParam("id") Integer hospitalId) {
        List<Paciente> pacientes = pacienteRepository.obtenerPacientesPorHospital(hospitalId);
        model.addAttribute("pacientes", pacientes);
        return "hospital/paciente";
    }
}
