package uni.edu.pe.x01ecommercegreedisgood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;

    private String descripcion;

    @ManyToMany(mappedBy = "categorias")
    private List<CuentaUsuario> usuarios;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    @OneToMany(mappedBy = "categoria")
    private List<Cupon> cupones;
}
