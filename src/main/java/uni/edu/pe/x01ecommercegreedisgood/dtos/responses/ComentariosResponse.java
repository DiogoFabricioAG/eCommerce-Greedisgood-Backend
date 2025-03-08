package uni.edu.pe.x01ecommercegreedisgood.dtos.responses;

import java.util.Date;

public record ComentariosResponse(
        String text,
        String subject,
        String user,
        Integer rating,
        Date date
) {
}
