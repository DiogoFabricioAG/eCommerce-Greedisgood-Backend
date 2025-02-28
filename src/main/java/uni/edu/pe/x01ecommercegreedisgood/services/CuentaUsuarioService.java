package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.LoginRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.UserDataResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CuentaPersonaMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;

@Service
public class CuentaUsuarioService implements iCuentaUsuarioService {

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CuentaPersonaMapper cuentaPersonaMapper;

    @Override
    public UserDataResponse LogeoUsuario(LoginRequest request) {
        if (cuentaUsuarioRepository.existsByCorreoElectronicoAndContrasena(request.email(), request.password())){
            CuentaUsuario cuentaUsuario = cuentaUsuarioRepository.findByCorreoElectronicoAndContrasena(request.email(), request.password());
            return cuentaPersonaMapper.toUserDataResponse(cuentaUsuario);
        }
        else {
            throw new RuntimeException("No existe esta cuenta");
        }
    }
}
