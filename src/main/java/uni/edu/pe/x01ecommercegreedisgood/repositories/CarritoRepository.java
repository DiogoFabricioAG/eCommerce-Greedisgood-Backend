package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    boolean existsByCuentaUsuario(CuentaUsuario cuentaUsuario);
    Carrito findByCuentaUsuario(CuentaUsuario cuentaUsuario);
}
