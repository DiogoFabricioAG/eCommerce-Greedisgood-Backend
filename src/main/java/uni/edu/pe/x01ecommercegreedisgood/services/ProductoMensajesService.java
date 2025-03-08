package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ComentariosRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ComentariosResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.ComentarioMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.models.ProductoMensajes;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoMensajesRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoMensajesService implements iProductoMensajeService{

    @Autowired
    private ProductoMensajesRepository productoMensajesRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private ComentarioMapper comentarioMapper;

    @Override
    public ComentariosResponse createComentario(ComentariosRequest comentariosRequest) {
        CuentaUsuario cuentaUsuario = cuentaUsuarioRepository.findBySlug(comentariosRequest.slug());
        Producto producto = productoRepository.findById(comentariosRequest.idProduct()).orElseThrow(() -> new RuntimeException("No existe un producto con este ID"));

        ProductoMensajes productoMensajes = comentarioMapper.toEntity(comentariosRequest,cuentaUsuario,producto);
        productoMensajesRepository.save(productoMensajes);

        return comentarioMapper.toResponse(productoMensajes);
    }

    @Override
    public List<ComentariosResponse> getAllComentarios(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("No existe un producto"));
        List<ProductoMensajes> productoMensajes = productoMensajesRepository.findAllByProducto(producto);
        return productoMensajes.stream().map(comentarioMapper::toResponse).collect(Collectors.toList());
    }
}
