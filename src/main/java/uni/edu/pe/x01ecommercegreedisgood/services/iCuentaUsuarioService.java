package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.LoginRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.UserDataResponse;

public interface iCuentaUsuarioService {
    UserDataResponse LogeoUsuario(LoginRequest request);
}
