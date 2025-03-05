package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CarritoProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CarritoProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.services.CarritoProductoService;
import uni.edu.pe.x01ecommercegreedisgood.services.CarritoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoProductoService carritoProductoService;

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/")
    public ResponseEntity<MessageResponse> create(@RequestBody CarritoProductoRequest carritoProductoRequest) {
        return new ResponseEntity<>(carritoProductoService.addProduct(carritoProductoRequest), HttpStatus.CREATED);
    };

    @GetMapping("/get-items/{slug}")
    public ResponseEntity<List<CarritoProductoResponse>> getAll(@PathVariable String slug) {
        List<CarritoProductoResponse> items = carritoService.getCartItems(slug);
        return ResponseEntity.ok(items);
    };
}
