package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;

public record ComentariosRequest (
        String slug,
        String text,
        Integer rating,
        String subject,
        Long idProduct
) {
}
