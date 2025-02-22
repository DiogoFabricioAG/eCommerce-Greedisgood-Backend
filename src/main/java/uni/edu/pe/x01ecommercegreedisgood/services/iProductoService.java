package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

import java.util.List;

public interface iProductoService {
    List<Producto> getAllProductos();
    Producto addProducto(ProductoRequest productoRequest);
}
