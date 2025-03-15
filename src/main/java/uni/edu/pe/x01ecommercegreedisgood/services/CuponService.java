package uni.edu.pe.x01ecommercegreedisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CuponRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.CuponResponse;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.mappers.CuponMapper;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.models.Cupon;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CategoriaRepository;
import uni.edu.pe.x01ecommercegreedisgood.repositories.CuponRepository;

@Service
public class CuponService implements iCuponService {

    @Autowired
    private CuponRepository cuponRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CuponMapper cuponMapper;

    @Override
    public MessageResponse createCupon(CuponRequest cuponRequest) {

        Categoria categoria = categoriaRepository.findById(cuponRequest.idCategoria()).orElseThrow(() -> new RuntimeException("No existe esta categoria"));

        Cupon cupon = cuponMapper.toEntity(cuponRequest,categoria);
        cuponRepository.save(cupon);

        return new MessageResponse(
                "Cupon creado exitosamente!",
                201
        );
    }

    @Override
    public CuponResponse useCupon(String cuponCode) {
        Cupon cupon = cuponRepository.findByCuponCode(cuponCode);

        if (cupon == null) {
            throw new RuntimeException("No existe esta cupon");
        }

        if (cupon.getCantidadUso() <= 0){
            throw new RuntimeException("Ya se ha agotado este cupon");
        }

        cupon.setCantidadUso(cupon.getCantidadUso() - 1);
        cuponRepository.save(cupon);

        return new CuponResponse(
                cupon.getId(),
                cuponCode
        );
    }

    @Override
    public MessageResponse testCupon(String cuponCode) {
        Categoria categoria = categoriaRepository.findById(1L).orElseThrow(() -> new RuntimeException("No existe esta categoria"));
        Cupon cupon = cuponMapper.toEntityTest(cuponCode,categoria);
        cuponRepository.save(cupon);
        return new MessageResponse(
                "TESTEADO",
                200
        );
    }

}
