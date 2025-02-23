package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.GaleriaProductoResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;

import java.util.List;
import java.util.Set;

public interface iCategoriaService {
    CategoriaResponse saveCategoria(CategoriaRequest categoriaRequest);
    List<CategoriaResponse> findAllCategorias();
}
