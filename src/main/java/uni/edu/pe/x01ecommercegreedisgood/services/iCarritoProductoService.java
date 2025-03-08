package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoGenRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;

import java.util.List;

public interface iCarritoProductoService {
    MessageResponse addProduct(CarritoProductoRequest carritoProductoRequest);
    MessageResponse updateProducts(List<CarritoProductoGenRequest> carritoProductoRequests, String slug);
    MessageResponse deleteProduct(String productName, String slug);
}
