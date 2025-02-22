package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CategoriaResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CategoriaMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements iCategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;


    @Override
    public CategoriaResponse saveCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequest);
        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public List<CategoriaResponse> findAllCategorias() {
        List<Categoria> categoria = categoriaRepository.findAll();
        return categoria.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
    }
}
