package uni.edu.pe.x01ecommercegreedisgood.dtos.responses;

import java.util.Date;

public record PedidoResponse(
        Long idPedido,
        String codigoPedido,
        Date fechaPedido,
        String estadoPedido,
        Double costoPedido
) {
}
