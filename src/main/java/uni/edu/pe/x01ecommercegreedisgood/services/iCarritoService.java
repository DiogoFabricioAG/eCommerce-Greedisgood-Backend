package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;

import java.util.List;

public interface iCarritoService {
    List<CarritoProductoResponse> getCartItems(String username);
}
