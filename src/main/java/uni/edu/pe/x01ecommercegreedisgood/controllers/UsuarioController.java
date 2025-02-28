package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CreacionCuentaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.LoginRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.UserDataResponse;
import uni.edu.pe.x01ecommercegreedisgood.services.CuentaPersonaService;
import uni.edu.pe.x01ecommercegreedisgood.services.CuentaUsuarioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private CuentaPersonaService cuentaPersonaService;

    @Autowired
    private CuentaUsuarioService cuentaUsuarioService;

    @PostMapping("/crear-cuenta")
    public ResponseEntity<MessageResponse> creacionCuenta(@RequestBody CreacionCuentaRequest creacionCuentaRequest) {
        MessageResponse respuesta = cuentaPersonaService.creacionCuentaPersona(creacionCuentaRequest);
        return ResponseEntity.ok(respuesta);
    };

    @PostMapping("/login")
    public ResponseEntity<UserDataResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(cuentaUsuarioService.LogeoUsuario(loginRequest));
    }
}
