package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.services.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @PostMapping("/")
    public ResponseEntity<Producto> save(@RequestBody ProductoRequest productoRequest) {
        Producto producto = productoService.addProducto(productoRequest);
        return ResponseEntity.ok(producto);
    }
}
