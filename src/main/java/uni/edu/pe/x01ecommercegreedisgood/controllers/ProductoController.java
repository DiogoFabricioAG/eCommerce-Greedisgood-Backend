package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ProductoRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.services.GaleriaProductoService;
import uni.edu.pe.x01ecommercegreedisgood.services.ProductoService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private GaleriaProductoService galeriaProductoService;


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
        ProductoResponse product = productoService.asignarCategoria(idProducto, idCategoria);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/images/{idProduct}")
    public ResponseEntity<Set<GaleriaProductoResponse>> findAllImages(@PathVariable Long idProduct) {
        return new ResponseEntity<>(productoService.findAllPhotos(idProduct), HttpStatus.OK);
    }

    @PostMapping("/images/save/{idProduct}")
    public ResponseEntity<GaleriaProductoResponse> saveImage(@PathVariable Long idProduct, @RequestParam("path") String pathImage) {
        return new ResponseEntity<>(galeriaProductoService.saveImage(pathImage,idProduct), HttpStatus.CREATED) ;
    }

}
