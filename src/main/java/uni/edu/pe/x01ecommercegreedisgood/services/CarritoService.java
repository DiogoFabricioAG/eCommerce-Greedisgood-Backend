package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CarritoProductoMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CarritoProductos;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoService implements iCarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CarritoProductoMapper carritoProductoMapper;

    @Override
    public List<CarritoProductoResponse> getCartItems(String slug) {
        CuentaUsuario cuentaUsuario = cuentaUsuarioRepository.findBySlug(slug);
        Carrito carrito = carritoRepository.findByCuentaUsuario(cuentaUsuario);
        return carrito.getCarritoProductos().stream().map(carritoProductoMapper::toResponse).collect(Collectors.toList());
    }
}
