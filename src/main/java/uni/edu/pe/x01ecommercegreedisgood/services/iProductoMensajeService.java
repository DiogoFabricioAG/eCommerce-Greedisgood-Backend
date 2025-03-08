package uni.edu.pe.x01ecommercegreedisgood.services;

import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.ComentariosRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.ComentariosResponse;

import java.util.List;

public interface iProductoMensajeService {

    ComentariosResponse createComentario(ComentariosRequest comentariosRequest);

    List<ComentariosResponse> getAllComentarios(Long idProducto);
}
