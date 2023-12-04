package com.example.pruebas.controladores;

import com.example.pruebas.modelo.Empleado;
import com.example.pruebas.servicios.ServicioEmpleado;
import com.example.pruebas.storage.StorageFileNotFoundException;
import com.example.pruebas.storage.StorageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;

@Controller
public class Principal {
    @Autowired
    ServicioEmpleado servicioEmpleado;
    @Autowired
    StorageService storageService;

    @GetMapping("/")
    public String principal(Model model, @RequestParam(name="q",required=false) String query ){
        ArrayList<Empleado> empleados = (query == null) ? servicioEmpleado.findAll() : servicioEmpleado.buscador(query);
        model.addAttribute("empleados", empleados);
        return "index";
    }

    @GetMapping("/nuevo")
    public  String nuevoEmpleado(Model model){
        model.addAttribute("nuevoEmpleado", new Empleado());
        return "form";
    }
    @PostMapping("/nuevo/registro")
    public String agregarNuevoEmpleado(@ModelAttribute("nuevoEmpleado") Empleado empleado, @RequestParam("file") MultipartFile file){

            if(!file.isEmpty()){
                String avatar = storageService.store(file, empleado.getNombre());
                empleado.setImagen(MvcUriComponentsBuilder
                        .fromMethodName(FileUploadController.class, "serveFile", avatar).build().toUriString());
            }
            servicioEmpleado.save(empleado);
            return "redirect:/";
        }
    }

