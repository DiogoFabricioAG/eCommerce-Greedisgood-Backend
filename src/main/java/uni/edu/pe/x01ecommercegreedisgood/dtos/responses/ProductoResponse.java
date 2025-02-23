package uni.edu.pe.x01ecommercegreedisgood.dtos.responses;

import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;

import java.util.List;

public record ProductoResponse(
        Long id,

        Double price,

        String productName,

        String description,

        Integer stock,

        Boolean isDiscount,

        Double old,

        TipoDespacho dispatch,

        String category,

        List<String> images
) {
}
