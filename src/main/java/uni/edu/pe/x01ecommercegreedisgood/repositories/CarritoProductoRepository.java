package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.Carrito;
import uni.edu.pe.x01ecommercegreedisgood.models.CarritoProductos;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

@Repository
public interface CarritoProductoRepository extends JpaRepository<CarritoProductos, Long> {

    boolean existsByCarritoAndProducto(Carrito carrito, Producto producto);
}
