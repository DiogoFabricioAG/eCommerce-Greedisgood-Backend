package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaRequest.descripcion());
        categoria.setCategoria(categoriaRequest.categoria());
        return categoria;
    }
}
