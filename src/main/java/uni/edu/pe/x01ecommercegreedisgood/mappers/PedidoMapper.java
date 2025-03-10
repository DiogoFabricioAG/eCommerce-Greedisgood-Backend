package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.PedidoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;

@Component
public class PedidoMapper {

    public PedidoResponse toResponse(Pedido pedido, Double precio) {
      return new PedidoResponse(
              pedido.getId(),
              pedido.getCodigo(),
              pedido.getFechaPedido(),
              pedido.getTipoEstadoPedido().toString(),
              precio
      );
    };
}
