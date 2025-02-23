package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.GaleriaProducto;

@Component
public class GaleriaProductoMapper {

    public GaleriaProductoResponse toResponse(GaleriaProducto galeriaProducto) {
        return new GaleriaProductoResponse(
                galeriaProducto.getRutaImagen()
        );
    }
}
