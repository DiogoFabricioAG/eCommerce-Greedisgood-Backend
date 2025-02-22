package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CategoriaRequest;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CategoriaMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService implements iCategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;


    @Override
    public Categoria saveCategoria(CategoriaRequest categoriaRequest) {
        System.out.println(categoriaRequest);
        return categoriaRepository.save(categoriaMapper.toEntity(categoriaRequest));
    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }
}
