package uni.edu.pe.x01ecommercegreedisgood.dtos.responses;

import uni.edu.pe.x01ecommercegreedisgood.enums.TipoDespacho;

public record ProductoResponse(
        Long id,

        Double precio,

        String nombre,

        String descripcion,

        Integer reservas,

        Boolean enOferta,

        Double precioAntiguo,

        TipoDespacho tipoDespacho
) {
}
