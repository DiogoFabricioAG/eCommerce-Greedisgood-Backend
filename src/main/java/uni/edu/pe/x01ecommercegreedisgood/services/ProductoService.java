package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.GaleriaProductoMapper;
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
    private GaleriaProductoMapper galeriaProductoMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private GaleriaProductoService galeriaProductoService;

    @Override
    public List<ProductoResponse> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoResponse> productoResponses = new ArrayList<>();
        for (Producto producto : productos) {
            List<GaleriaProductoResponse> galeriaProducto = producto.getImagenes().stream().map(galeriaProductoMapper::toResponse).toList();
            List<String> images = galeriaProducto.stream().map(GaleriaProductoResponse::rutaImage).toList();
            productoResponses.add(productoMapper.toResponse(producto,images));
        }
        return productoResponses;
    }

    @Override
    public Set<GaleriaProductoResponse> findAllPhotos(Long idProduct) {
        Producto producto = productoRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return producto.getImagenes().stream().map(galeriaProductoMapper::toResponse).collect(Collectors.toSet());
    }

    @Override
    public ProductoResponse addProducto(ProductoRequest productoRequest) {
        Producto producto = productoRepository.save(productoMapper.toEntity(productoRequest));
        List<GaleriaProductoResponse> galeriaProducto = producto.getImagenes().stream().map(galeriaProductoMapper::toResponse).toList();
        List<String> images = galeriaProducto.stream().map(GaleriaProductoResponse::rutaImage).toList();
        return productoMapper.toResponse(producto, images);
    }

    @Override
    @Transactional
    public ProductoResponse asignarCategoria(Long idProducto, Long idCategorias) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(idCategorias).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        producto.setCategoria(categoria);
        Producto productoActualizado = productoRepository.save(producto);
        List<GaleriaProductoResponse> galeriaProducto = producto.getImagenes().stream().map(galeriaProductoMapper::toResponse).toList();
        List<String> images = galeriaProducto.stream().map(GaleriaProductoResponse::rutaImage).toList();

        return productoMapper.toResponse(productoActualizado,images);
    }


}
