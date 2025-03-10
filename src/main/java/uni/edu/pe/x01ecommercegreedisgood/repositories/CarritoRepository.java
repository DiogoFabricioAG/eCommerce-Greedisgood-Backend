package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;

import java.util.List;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    boolean existsByCuentaUsuarioAndTipoCarritoNot(CuentaUsuario cuentaUsuario, TipoCarrito tipoCarrito);

    Carrito findByCuentaUsuarioAndTipoCarritoNot(CuentaUsuario cuentaUsuario, TipoCarrito tipoCarrito);
    List<Carrito> findAllByCuentaUsuarioAndTipoCarritoNot(CuentaUsuario cuentaUsuario,TipoCarrito tipoCarrito);

}
