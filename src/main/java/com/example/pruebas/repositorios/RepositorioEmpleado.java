package com.example.pruebas.repositorios;

import com.example.pruebas.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long> {
    public ArrayList<Empleado> findAll();
    public Empleado findById(long id);

    public ArrayList<Empleado> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCaseOrCargoContainsIgnoreCase(String nombre, String apellidos, String cargo);
}
