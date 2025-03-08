package uni.edu.pe.x01ecommercegreedisgood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Pedido;
import uni.edu.pe.x01ecommercegreedisgood.services.PedidoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/{slug}")
    public ResponseEntity<MessageResponse> createPedido(@PathVariable String slug) {
      MessageResponse response =  pedidoService.addPedido(slug);
      return ResponseEntity.ok(response);
    };
}
