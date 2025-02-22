package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;


import jakarta.validation.constraints.NotNull;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;

public record ProductoRequest(
        @NotNull Double precio,

        @NotNull String nombre,

        String descripcion,

        @NotNull Integer reservas,

        @NotNull Boolean enOferta,

        Double precioAntiguo,

        @NotNull TipoDespacho tipoDespacho
) {
}
