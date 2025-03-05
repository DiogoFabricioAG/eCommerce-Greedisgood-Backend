package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;

public interface iCarritoProductoService {
    MessageResponse addProduct(CarritoProductoRequest carritoProductoRequest);

}
