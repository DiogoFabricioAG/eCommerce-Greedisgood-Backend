package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.PedidoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Service
public class PedidoService implements iPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CuentaUsuarioRepository cuentaUsuarioRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public MessageResponse addPedido(String slug) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fechaFormateada = fechaActual.format(formatter);

        CuentaUsuario cuenta = cuentaUsuarioRepository.findBySlug(slug);
        Carrito carrito = carritoRepository.findByCuentaUsuarioAndTipoCarritoNot(cuenta,TipoCarrito.COMPLETADO);
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());
        pedido.setCarrito(carrito);
        carrito.setTipoCarrito(TipoCarrito.COMPLETADO);
        carritoRepository.save(carrito);

        pedido.setCodigo("P"+fechaFormateada+ cuenta.getId().toString());
        pedidoRepository.save(pedido);

        return new MessageResponse(
                "Pedido creado exitosamente",
                200
        );
    }
}
