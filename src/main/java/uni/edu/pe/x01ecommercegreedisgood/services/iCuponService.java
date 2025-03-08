package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CuponRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;

public interface iCuponService {

    MessageResponse createCupon(CuponRequest cuponRequest);
}
