package com.centro.integral.medico.repository;

import com.centro.integral.medico.repository.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public Optional<Usuario> findByCedula(String cedula);

}
