package uni.edu.pe.x01ecommercegreedisgood.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuenta_usuario")
public class CuentaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String slug;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "nro_celular", length = 9)
    private String nroCelular;

    private String contrasena;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private CuentaPersona Persona;

    @Column(name = "fecha_inicio")
    private Date fechaInicio = new Date();

    @Column(name = "es_vendedor")
    private Boolean esVendedor = false;

    @ManyToMany
    @JoinTable(
            name = "usuario_preferencias",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categorias;

}
