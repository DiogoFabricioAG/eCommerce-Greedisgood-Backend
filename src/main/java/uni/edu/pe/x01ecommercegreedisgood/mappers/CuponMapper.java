package uni.edu.pe.x01ecommercegreedisgood.mappers;

import org.springframework.stereotype.Component;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CuponRequest;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;
import uni.edu.pe.x01ecommercegreedisgood.models.Cupon;

@Component
public class CuponMapper {

    public Cupon toEntity(CuponRequest cuponRequest, Categoria category) {
        Cupon cupon = new Cupon();
        cupon.setCuponCode(cuponRequest.cuponCode());
        cupon.setCategoria(category);
        cupon.setCantidadUso(cuponRequest.cantidadUso());
        cupon.setPorcentajeDescuento(cuponRequest.porcentajeDescuento());
        return cupon;
    }

    public Cupon toEntityTest(String cuponCode, Categoria categoria) {
        Cupon cupon = new Cupon();
        cupon.setCuponCode(cuponCode);
        cupon.setCategoria(categoria);
        cupon.setCantidadUso(1);
        cupon.setPorcentajeDescuento(0.2);
        return cupon;
    }

}
