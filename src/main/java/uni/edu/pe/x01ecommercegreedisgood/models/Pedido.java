package uni.edu.pe.x01ecommercegreedisgood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoEstadoPedido;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String codigo;

    @OneToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    @Column(nullable = false, name = "fecha_pedido")
    private Date fechaPedido;

    @ManyToOne
    @JoinColumn(name = "id_cupon")
    private Cupon cupon;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estado")
    private TipoEstadoPedido tipoEstadoPedido;
}
