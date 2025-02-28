package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

import java.util.List;
import java.util.Set;

public interface iProductoService {
    List<ProductoResponse> getAllProductos();
    ProductoResponse addProducto(ProductoRequest productoRequest);
    ProductoResponse asignarCategoria(Long idProducto, Long idCategorias);
    Set<GaleriaProductoResponse> findAllPhotos(Long idProduct);
    ProductoResponse findById(Long idProducto);
}
