package uni.edu.pe.x01ecommercegreedisgood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto_mensaje")
public class ProductoMensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asunto;

    private String mensaje;

    @Column(nullable = true)
    private Integer calificacion;

    @Column(nullable = true)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private CuentaUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
