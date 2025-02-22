package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.mappers.ProductoMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoRepository;

import java.util.List;
@Service
public class ProductoService implements iProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;


    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto addProducto(ProductoRequest productoRequest) {
        return productoRepository.save(productoMapper.toEntity(productoRequest));
    }
    
}
