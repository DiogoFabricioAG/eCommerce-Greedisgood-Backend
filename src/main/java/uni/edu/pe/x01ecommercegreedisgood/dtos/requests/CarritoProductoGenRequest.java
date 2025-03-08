package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;

public record CarritoProductoGenRequest(
        String productName,
        Double unitPrice,
        String imageSource,
        Integer quantity
) {
}
