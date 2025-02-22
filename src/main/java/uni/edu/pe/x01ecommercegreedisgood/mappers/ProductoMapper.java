package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequest productoRequest) {
        Producto producto = new Producto();
        producto.setDescripcion(productoRequest.descripcion());
        producto.setPrecio(productoRequest.precio());
        producto.setNombre(productoRequest.nombre());
        producto.setTipoDespacho(productoRequest.tipoDespacho());
        producto.setReservas(productoRequest.reservas());
        if (productoRequest.enOferta() != null){
            producto.setEnOferta(productoRequest.enOferta());
        } else {
            producto.setEnOferta(false);
        }
        if (productoRequest.precioAntiguo() != null){
            producto.setPrecioAntiguo(productoRequest.precioAntiguo());
        }
        return producto;
    }
}
