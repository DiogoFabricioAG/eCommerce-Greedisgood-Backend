package uni.edu.pe.x01ecommercegreedisgood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.x01ecommercegreedisgood.models.CuentaUsuario;

@Repository
public interface CuentaUsuarioRepository extends JpaRepository<CuentaUsuario, Long> {
    boolean existsBycorreoElectronico(String correo);
    boolean existsBySlug(String slug);

    boolean existsByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);
    CuentaUsuario findByCorreoElectronicoAndContrasena(String correo, String contrasena);
}
