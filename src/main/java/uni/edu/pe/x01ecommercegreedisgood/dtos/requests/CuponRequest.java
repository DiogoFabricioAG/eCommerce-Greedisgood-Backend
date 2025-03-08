package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;


public record CuponRequest(
        String cuponCode,
        Double porcentajeDescuento,
        Integer cantidadUso,
        Long idCategoria
) {
}
