package com.example.lab3.Controller;

import com.example.lab3.Entity.Doctor;
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
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @GetMapping(value = {"","/"})
    public String listaDoctores(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();
        model.addAttribute("doctores", doctores);
        return "doctor/list";
    }

    @GetMapping(value = "/paciente")
    public String listaPacientesPorDoctor(Model model, @RequestParam Integer id) {
        List<Paciente> pacientes = pacienteRepository.obtenerPacientesPorDoctor(id);
        model.addAttribute("pacientes", pacientes);
        return "doctor/paciente";
    }

}
