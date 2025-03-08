package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;
import uni.edu.pe.x01ecommercegreedisgood.models.ProductoMensajes;

import java.util.List;

@Repository
public interface ProductoMensajesRepository  extends JpaRepository<ProductoMensajes, Long> {
    List<ProductoMensajes> findAllByProducto(Producto producto);
}

