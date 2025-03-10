package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.PedidoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;
import uni.edu.pe.x01ecommercegreedisgood.models.Cupon;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CarritoRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuentaUsuarioRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuponRepository;
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
    @Autowired
    private CuponRepository cuponRepository;

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
}
