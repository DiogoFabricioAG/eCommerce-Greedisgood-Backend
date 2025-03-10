package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.PedidoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.PedidoResponse;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoEstadoPedido;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CarritoProductoMapper;
import uni.edu.pe.x01ecommercegreedisgood.mappers.PedidoMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.*;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuponRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.PedidoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoService implements iPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CuponRepository cuponRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private CarritoProductoMapper carritoProductoMapper;

    @Override
    public MessageResponse addPedido(PedidoRequest pedidoRequest) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10)); // Genera un número entre 0 y 9
        }

        CuentaUsuario cuenta = cuentaUsuarioRepository.findBySlug(pedidoRequest.slug());
        Carrito carrito = carritoRepository.findByCuentaUsuarioAndTipoCarritoNot(cuenta,TipoCarrito.COMPLETADO);

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());
        pedido.setCarrito(carrito);
        pedido.setTipoEstadoPedido(TipoEstadoPedido.PREPARANDO);
        carrito.setTipoCarrito(TipoCarrito.COMPLETADO);
        carritoRepository.save(carrito);

        pedido.setCodigo("P"+sb.toString());
        if (pedidoRequest.idCupon() != null) {
            Cupon cupon = cuponRepository.findById(pedidoRequest.idCupon()).orElseThrow(() -> new RuntimeException("No existe ese cupon"));
            pedido.setCupon(cupon);
        }
        pedidoRepository.save(pedido);

        return new MessageResponse(
                "Pedido creado exitosamente",
                200
        );
    }

    @Override
    public List<PedidoResponse> getAllPedidos(String slug) {
        CuentaUsuario cuenta = cuentaUsuarioRepository.findBySlug(slug);
        List<Carrito> carritos = carritoRepository.findAllByCuentaUsuarioAndTipoCarritoNot(cuenta,TipoCarrito.USO);
        List<Pedido> pedidos = carritos.stream().map(pedidoRepository::findByCarrito).toList();
        List<PedidoResponse> pedidoResponses = new ArrayList<>();
        Double price;
        for (Pedido pedido : pedidos) {
            price = 0.0;
            for (CarritoProductos carritoProductos : pedido.getCarrito().getCarritoProductos()){
                price += carritoProductos.getProducto().getPrecio()*carritoProductos.getCantidad();
            }
            if (pedido.getCupon() != null) {
                price *= (1-pedido.getCupon().getPorcentajeDescuento());
            }
            pedidoResponses.add(pedidoMapper.toResponse(pedido, price));
        }
        return pedidoResponses;
    }

    @Override
    public List<CarritoProductoResponse> getAllProducts(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException("No existe ese pedido"));
        return pedido.getCarrito().getCarritoProductos().stream().map(carritoProductoMapper::toResponse).collect(Collectors.toList());
    }
}
