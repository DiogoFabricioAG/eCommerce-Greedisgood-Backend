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
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "cupon_code")
    private String cuponCode;

    @Column(nullable = false, name = "porcentaje_descuento")
    private Double porcentajeDescuento;

    @Column(nullable = false, name = "cantidad_uso")
    private Integer cantidadUso;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToMany(mappedBy = "cupones")
    private List<Producto> productos;
}
