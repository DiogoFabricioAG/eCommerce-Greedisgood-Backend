package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

import java.util.List;

public interface iProductoService {
    List<ProductoResponse> getAllProductos();
    ProductoResponse addProducto(ProductoRequest productoRequest);
    ProductoResponse asignarCategorias(Long idProducto, Long idCategorias);
    List<CategoriaResponse> findAllCategorias(Long idProducto);
}
