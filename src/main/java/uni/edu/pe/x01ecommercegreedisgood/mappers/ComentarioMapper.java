package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ComentariosRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ComentariosResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.models.ProductoMensajes;

import java.util.Date;

@Component
public class ComentarioMapper {

    public ProductoMensajes toEntity(ComentariosRequest comentariosRequest, CuentaUsuario cuentaUsuario, Producto producto) {
        ProductoMensajes productoMensajes = new ProductoMensajes();
        productoMensajes.setMensaje(comentariosRequest.text());
        productoMensajes.setAsunto(comentariosRequest.subject());
        productoMensajes.setCalificacion(comentariosRequest.rating());
        productoMensajes.setProducto(producto);
        productoMensajes.setUsuario(cuentaUsuario);
        productoMensajes.setFecha(new Date());
        return productoMensajes;
    }

    public ComentariosResponse toResponse(ProductoMensajes productoMensajes) {
        return new ComentariosResponse(
                productoMensajes.getMensaje(),
                productoMensajes.getAsunto(),
                productoMensajes.getUsuario().getNombreUsuario(),
                productoMensajes.getCalificacion(),
                productoMensajes.getFecha()
        );
    }
}
