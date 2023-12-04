package com.example.pruebas.servicios;

import com.example.pruebas.modelo.Empleado;
import com.example.pruebas.repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEmpleado {
    @Autowired
    RepositorioEmpleado repositorioEmpleado;

    public ArrayList<Empleado> findAll(){
        return repositorioEmpleado.findAll();
    }

    public Empleado findById(long id){
        return repositorioEmpleado.findById(id);
    }

    public void save(Empleado empleado){
        repositorioEmpleado.save(empleado);
    }

    public ArrayList<Empleado> buscador(String cadena){
        return repositorioEmpleado.findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCaseOrCargoContainsIgnoreCase(cadena, cadena, cadena);
    }
}
