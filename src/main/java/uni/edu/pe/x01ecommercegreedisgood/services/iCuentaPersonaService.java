package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CreacionCuentaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.LoginRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;

public interface iCuentaPersonaService {
    MessageResponse creacionCuentaPersona(CreacionCuentaRequest request);

}
