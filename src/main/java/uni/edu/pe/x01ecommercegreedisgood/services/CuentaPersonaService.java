package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CreacionCuentaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.LoginRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CuentaPersonaMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaPersona;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaPersonaRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;

@Service
public class CuentaPersonaService implements iCuentaPersonaService{

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CuentaPersonaRepository cuentaPersonaRepository;

    @Autowired
    private CuentaPersonaMapper cuentaPersonaMapper;

    @Override
    public MessageResponse creacionCuentaPersona(CreacionCuentaRequest request) {

        if (cuentaUsuarioRepository.existsBycorreoElectronico(request.email())){
            return new MessageResponse(
                    "Esta cuenta ya existe",
                    500
            );
        }

        if (cuentaUsuarioRepository.existsBySlug(request.firstname().toLowerCase() + "-" + request.lastname().toLowerCase())){
            return new MessageResponse(
                    "El slug ya existe",
                    500
            );
        }

        CuentaPersona cuentaPersona = cuentaPersonaRepository.save(cuentaPersonaMapper.toCuentaPersona(request));
        CuentaUsuario cuentaUsuario = cuentaUsuarioRepository.save(cuentaPersonaMapper.toCuentaUsuario(request,cuentaPersona));

        return new MessageResponse(
                "Creacion de cuenta exitosa!",
                        201
        );
    }
}
