package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;


import jakarta.validation.constraints.NotNull;
import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;
import uni.edu.pe.x01ecommercegreedisgood.models.Categoria;

public record ProductoRequest(
        @NotNull Double price,

        @NotNull String productName,

        String description,

        @NotNull Integer stock,

        @NotNull Boolean isDiscount,

        Double old,

        @NotNull TipoDespacho dispatch
) {
}
