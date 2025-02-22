package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.services.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<List<ProductoResponse>> findAll() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @PostMapping("/")
    public ResponseEntity<ProductoResponse> save(@RequestBody ProductoRequest productoRequest) {
        ProductoResponse product = productoService.addProducto(productoRequest);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/addCategorias/{idProducto}/{idCategoria}")
    public ResponseEntity<ProductoResponse> addCategorias(@PathVariable Long idProducto, @PathVariable Long idCategoria) {
        ProductoResponse product = productoService.asignarCategorias(idProducto,idCategoria);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/categorias/{idProducto}")
    public ResponseEntity<List<CategoriaResponse>> findAllCategorias(@PathVariable Long idProducto) {
        List<CategoriaResponse> categorias = productoService.findAllCategorias(idProducto);
        return ResponseEntity.ok(categorias);
    }
}
