package uni.edu.pe.x01ecommercegreedisgood.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

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

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    List<GaleriaProducto> imagenes;

    @ManyToMany
    @JoinTable(
            name = "oferta_productos",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_cupon")
    )
    private List<Cupon> cupones;
}
