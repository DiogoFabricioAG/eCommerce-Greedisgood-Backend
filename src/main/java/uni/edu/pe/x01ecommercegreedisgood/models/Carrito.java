package uni.edu.pe.x01ecommercegreedisgood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoCarrito;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private CuentaUsuario cuentaUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_carrito")
    private TipoCarrito tipoCarrito;

    @OneToMany(mappedBy = "carrito")
    private List<CarritoProductos> carritoProductos;


}
