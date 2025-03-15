package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoGenRequest;
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

import java.util.List;

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
        if (!carritoRepository.existsByCuentaUsuarioAndTipoCarritoNot(usuario,TipoCarrito.COMPLETADO)) {
            Carrito newCarrito = new Carrito();
            newCarrito.setCuentaUsuario(usuario);
            newCarrito.setTipoCarrito(TipoCarrito.USO);
            carrito = carritoRepository.save(newCarrito);
        }
        else {
            carrito = carritoRepository.findByCuentaUsuarioAndTipoCarritoNot(usuario,TipoCarrito.COMPLETADO);
        }

        Producto producto = productoRepository.findById(carritoProductoRequest.idProducto()).orElseThrow(() -> new RuntimeException("No existe el producto"));
        if (producto.getReservas() <= 0){
            return new MessageResponse("No hay más Reservas de este producto",501);
        }
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
            producto.setReservas(producto.getReservas() - 1);
            carritoProductoRepository.save(carritoProductos);
        }

        return new MessageResponse(
                "Agregado con exito",
                201
        );
    }

    @Override
    public MessageResponse updateProducts(List<CarritoProductoGenRequest> carritoProductoRequests, String slug) {
        CuentaUsuario usuario = cuentaUsuarioRepository.findBySlug(slug);
        Carrito carrito = carritoRepository.findByCuentaUsuarioAndTipoCarritoNot(usuario,TipoCarrito.COMPLETADO);;

        CarritoProductos carritoProductos;
        Producto producto;
        for (CarritoProductoGenRequest carritoProducto : carritoProductoRequests) {
            producto = productoRepository.findByNombre(carritoProducto.productName());
            carritoProductos = carritoProductoRepository.findByCarritoAndProducto(carrito, producto);
            producto.setReservas(producto.getReservas() + carritoProductos.getCantidad() - carritoProducto.quantity());

            carritoProductos.setCantidad(carritoProducto.quantity());
            productoRepository.save(producto);
            carritoProductoRepository.save(carritoProductos);
        }
        return new MessageResponse(
                "Cambio Exitoso",
                200
        );
    }

    @Override
    public MessageResponse deleteProduct(String productName, String slug) {
        CuentaUsuario usuario = cuentaUsuarioRepository.findBySlug(slug);
        Carrito carrito = carritoRepository.findByCuentaUsuarioAndTipoCarritoNot(usuario,TipoCarrito.COMPLETADO);;
        Producto producto = productoRepository.findByNombre(productName);
        CarritoProductos carritoProductos = carritoProductoRepository.findByCarritoAndProducto(carrito, producto);

        carritoProductoRepository.delete(carritoProductos);
        return new MessageResponse(
                "Producto Eliminado del Carrito",
                200
        );
    }
}
