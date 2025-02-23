package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.GaleriaProductoMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.GaleriaProducto;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.repositories.GaleriaProductoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoRepository;

@Service
public class GaleriaProductoService {

    @Autowired
    private GaleriaProductoRepository galeriaProductoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private GaleriaProductoMapper galeriaProductoMapper;

    public GaleriaProductoResponse saveImage(String imagenProducto, Long idProduct) {
        Producto producto = productoRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        GaleriaProducto galeria = new GaleriaProducto();
        galeria.setProducto(producto);
        System.out.println(imagenProducto);
        galeria.setRutaImagen(imagenProducto);
        return galeriaProductoMapper.toResponse(galeriaProductoRepository.save(galeria));
    }
}
