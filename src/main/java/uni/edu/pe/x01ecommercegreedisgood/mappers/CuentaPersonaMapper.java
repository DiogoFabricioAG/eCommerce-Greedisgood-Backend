package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CreacionCuentaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.UserDataResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaPersona;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;

@Component
public class CuentaPersonaMapper {

    public CuentaPersona toCuentaPersona(CreacionCuentaRequest request) {
        CuentaPersona cuentaPersona = new CuentaPersona();
        cuentaPersona.setApellido(request.lastname());
        cuentaPersona.setNombre(request.firstname());
        return cuentaPersona;
    }

    public CuentaUsuario toCuentaUsuario(CreacionCuentaRequest request, CuentaPersona cuentaPersona) {
        CuentaUsuario cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setPersona(cuentaPersona);
        cuentaUsuario.setNombreUsuario(request.firstname()+" "+request.lastname());
        cuentaUsuario.setSlug(request.firstname().toLowerCase()+"-"+request.lastname().toLowerCase());
        cuentaUsuario.setContrasena(request.password());
        cuentaUsuario.setCorreoElectronico(request.email());
        cuentaUsuario.setNroCelular(request.number());
        return cuentaUsuario;
    }
    public UserDataResponse toUserDataResponse(CuentaUsuario cuentaUsuario) {
        return new UserDataResponse(
                cuentaUsuario.getNombreUsuario(),
                cuentaUsuario.getCorreoElectronico(),
                true
        );
    };
}
