package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.GaleriaProducto;
import uni.edu.pe.x01ecommercegreedisgood.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Producto findByNombre(String nombre);
}


