package uni.edu.pe.x01ecommercegreedisgood.services;


import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;

public interface iPedidoService {
    MessageResponse addPedido(String slug);
}
