package uni.edu.pe.x01ecommercegreedisgood.services;


import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.PedidoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.PedidoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;

import java.util.List;

public interface iPedidoService {
    MessageResponse addPedido(PedidoRequest pedidoRequest);
    List<PedidoResponse> getAllPedidos(String slug);

    List<CarritoProductoResponse> getAllProducts(Long idPedido);
}
