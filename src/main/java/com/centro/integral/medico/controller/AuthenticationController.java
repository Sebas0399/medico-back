package com.centro.integral.medico.controller;

import com.centro.integral.medico.service.AuthenticationService;
import com.centro.integral.medico.service.dto.AuthenticationRequest;
import com.centro.integral.medico.service.dto.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired

    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest) {
        System.out.println(authRequest);
        AuthenticationResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String oldToken) {
        String newToken = authenticationService.renewToken(oldToken);
        return ResponseEntity.ok(new AuthenticationResponse(newToken));
    }

    @GetMapping("/public-access")
    public ResponseEntity<String> publicAccessEndPoint() {
        return ResponseEntity.ok("EndPointPublico");
    }
}