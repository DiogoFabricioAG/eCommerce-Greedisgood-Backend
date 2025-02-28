package uni.edu.pe.x01ecommercegreedisgood.dtos.requests;

public record CreacionCuentaRequest(
        String email,
        String password,
        String firstname,
        String lastname,
        String number
) {
}
