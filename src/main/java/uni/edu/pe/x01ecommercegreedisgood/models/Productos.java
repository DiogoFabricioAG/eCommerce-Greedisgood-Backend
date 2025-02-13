package uni.edu.pe.x01ecommercegreedisgood.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precio;

    private String nombre;

    private String descripcion;

    private Integer reservas;

    @Column(name = "en_oferta")
    private Boolean enOferta;

    @Column(name = "precio_antiguo")
    private Double precioAntiguo;

    @Enumerated(EnumType.STRING)
    private TipoDespacho tipoDespacho;

    @ManyToMany
    @JoinTable(
            name = "producto_categorias",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categorias> categorias;

    @ManyToMany
    @JoinTable(
            name = "oferta_productos",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_cupon")
    )
    private List<Cupon> cupones;
}
