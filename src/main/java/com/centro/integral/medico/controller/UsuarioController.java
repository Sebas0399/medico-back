package com.centro.integral.medico.controller;

import com.centro.integral.medico.repository.UsuarioRepository;
import com.centro.integral.medico.repository.entity.Usuario;
import com.centro.integral.medico.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{cedula}")

    public ResponseEntity<Usuario> getUsuario(@PathVariable String cedula) {
        Usuario usuario = usuarioRepository.findByCedula(cedula).get();
        if (usuario == null) {
            return ResponseEntity.internalServerError().body(null);
        } else {
            return ResponseEntity.ok().body(usuario);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registro(@RequestBody Usuario usuario) {
        Optional<Usuario> usuario1 = this.usuarioRepository.findByCedula(usuario.getCedula());
        if (usuario1.isEmpty()) {
            String key = usuario.getPassword();
            usuario.setPassword(passwordEncoder.encode(key));
            usuario.setRol(Role.ENFERMERO);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}