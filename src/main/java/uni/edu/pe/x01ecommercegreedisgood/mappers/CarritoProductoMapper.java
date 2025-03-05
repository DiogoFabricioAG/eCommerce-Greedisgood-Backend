package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.CarritoProductos;
import uni.edu.pe.x01ecommercegreedisgood.models.GaleriaProducto;

import java.util.List;

@Component
public class CarritoProductoMapper {

    public CarritoProductoResponse toResponse(CarritoProductos carritoProductos) {
        List<GaleriaProducto> imagenes =  carritoProductos.getProducto().getImagenes();
        String sourceImage;
        if (imagenes.isEmpty()) {
            sourceImage = null;
        }
        else {
            sourceImage = imagenes.get(0).getRutaImagen();
        }
        return new CarritoProductoResponse(
                carritoProductos.getProducto().getNombre(),
                carritoProductos.getProducto().getPrecio(),
                sourceImage,
                carritoProductos.getCantidad()
        );
    }
}
