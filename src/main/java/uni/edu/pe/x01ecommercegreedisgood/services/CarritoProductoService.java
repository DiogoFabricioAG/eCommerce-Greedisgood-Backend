package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CarritoProductos;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoProductoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.ProductoRepository;

@Service
public class CarritoProductoService implements iCarritoProductoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public MessageResponse addProduct(CarritoProductoRequest carritoProductoRequest) {
        // Falta el tema de Estado Carrito

        CuentaUsuario usuario =  cuentaUsuarioRepository.findByNombreUsuario(carritoProductoRequest.username());
        Carrito carrito;
        if (!carritoRepository.existsByCuentaUsuario(usuario)) {
            Carrito newCarrito = new Carrito();
            newCarrito.setCuentaUsuario(usuario);
            newCarrito.setTipoCarrito(TipoCarrito.USO);
            carrito = carritoRepository.save(newCarrito);
        }
        else {
            carrito = carritoRepository.findByCuentaUsuario(usuario);
        }

        Producto producto = productoRepository.findById(carritoProductoRequest.idProducto()).orElseThrow(() -> new RuntimeException("No existe el producto"));
        System.out.println(carritoProductoRepository.existsByCarritoAndProducto(carrito, producto));
        if (carritoProductoRepository.existsByCarritoAndProducto(carrito, producto)) {
            return new MessageResponse(
                    "El producto ya esta en el carrito",
                    501
            );
        }
        else{
            CarritoProductos carritoProductos = new CarritoProductos();
            carritoProductos.setCarrito(carrito);
            carritoProductos.setProducto(producto);
            carritoProductos.setCantidad(1);
            carritoProductoRepository.save(carritoProductos);
        }

        return new MessageResponse(
                "Agregado con exito",
                201
        );
    }
}
