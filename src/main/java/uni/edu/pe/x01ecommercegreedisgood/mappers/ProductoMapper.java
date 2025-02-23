package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

import java.util.List;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequest productoRequest) {
        Producto producto = new Producto();
        producto.setDescripcion(productoRequest.description());
        producto.setPrecio(productoRequest.price());
        producto.setNombre(productoRequest.productName());
        producto.setTipoDespacho(productoRequest.dispatch());
        producto.setReservas(productoRequest.stock());
        if (productoRequest.isDiscount() != null){
            producto.setEnOferta(productoRequest.isDiscount());
        } else {
            producto.setEnOferta(false);
        }
        if (productoRequest.old() != null){
            producto.setPrecioAntiguo(productoRequest.old());
        }
        return producto;
    }

    public ProductoResponse toResponse(Producto producto, List<String> images) {
        if (producto.getCategoria() == null){
            return new ProductoResponse(
                    producto.getId(),
                    producto.getPrecio(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getReservas(),
                    producto.getEnOferta(),
                    producto.getPrecioAntiguo(),
                    producto.getTipoDespacho(),
                    "",
                    images
            );
        }
        return new ProductoResponse(
                producto.getId(),
                producto.getPrecio(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getReservas(),
                producto.getEnOferta(),
                producto.getPrecioAntiguo(),
                producto.getTipoDespacho(),
                producto.getCategoria().getCategoria(),
                images  
        );
    }
}
