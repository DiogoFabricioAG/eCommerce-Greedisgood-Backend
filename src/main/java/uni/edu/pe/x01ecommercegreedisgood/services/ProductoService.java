package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CategoriaMapper;
import uni.edu.pe.x01ecommercegreedisgood.mappers.ProductoMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CategoriaRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoService implements iProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<ProductoResponse> getAllProductos() {
        return productoRepository.findAll().stream().map(productoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ProductoResponse addProducto(ProductoRequest productoRequest) {
        Producto producto = productoRepository.save(productoMapper.toEntity(productoRequest));
        return productoMapper.toResponse(producto);
    }

    @Override
    @Transactional
    public ProductoResponse asignarCategorias(Long idProducto, Long idCategorias) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(idCategorias).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        Set<Categoria> categoriesActual = producto.getCategorias();
        categoriesActual.add(categoria);
        producto.setCategorias(categoriesActual);
        Producto productoActualizado = productoRepository.save(producto);

        return productoMapper.toResponse(productoActualizado);
    }

    @Override
    public List<CategoriaResponse> findAllCategorias(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        Set<Categoria> categoriesActual = producto.getCategorias();
        return categoriesActual.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
    }

}
