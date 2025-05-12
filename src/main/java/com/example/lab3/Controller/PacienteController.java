package com.example.lab3.Controller;

import com.example.lab3.Entity.Paciente;
import com.example.lab3.Repository.DoctorRepository;
import com.example.lab3.Repository.HospitalRepository;
import com.example.lab3.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @GetMapping(value = {"","/"})
    public String listaPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        return "patient/list";
    }

    @GetMapping("/edit")
    public String editPaciente(Model model, @RequestParam("id") int id) {
        Optional<Paciente> optpaciente = pacienteRepository.findById(id);

        if (optpaciente.isPresent()) {
            Paciente paciente = optpaciente.get();
            model.addAttribute("listaDoctores", doctorRepository.findAll());
            model.addAttribute("listaHospitales", hospitalRepository.findAll());
            model.addAttribute("paciente", paciente);
        }
        return "patient/edit";
    }

    @PostMapping("/update")
    public String updatePaciente(@ModelAttribute("paciente") Paciente paciente) {
        int id = paciente.getId();
        int hospitalId = paciente.getHospital().getId();
        int doctorId = paciente.getDoctor().getId();
        pacienteRepository.updatePaciente(doctorId, hospitalId, id);
        return "redirect:/paciente";
    }
}
