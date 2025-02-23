package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.GaleriaProducto;

@Repository
public interface GaleriaProductoRepository extends JpaRepository<GaleriaProducto, Long> {
}