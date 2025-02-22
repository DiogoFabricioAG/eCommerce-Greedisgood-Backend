package uni.edu.pe.x01ecommercegreedisgood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaService.saveCategoria(categoriaRequest);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> findAllCategorias() {
        List<Categoria> categorias = categoriaService.findAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}
