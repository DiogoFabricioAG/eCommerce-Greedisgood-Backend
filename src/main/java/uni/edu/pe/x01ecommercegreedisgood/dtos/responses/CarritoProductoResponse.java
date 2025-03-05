package uni.edu.pe.x01ecommercegreedisgood.dtos.responses;

public record CarritoProductoResponse(
        String productName,
        Double unitPrice,
        String imageSource,
        Integer quantity
) {
}
