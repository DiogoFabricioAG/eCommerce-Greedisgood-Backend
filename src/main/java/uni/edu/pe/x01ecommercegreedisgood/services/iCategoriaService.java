package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;

import java.util.List;

public interface iCategoriaService {
    Categoria saveCategoria(CategoriaRequest categoriaRequest);
    List<Categoria> findAllCategorias();
}
