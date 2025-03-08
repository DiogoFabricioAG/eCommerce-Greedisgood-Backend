package uni.edu.pe.x01ecommercegreedisgood.controllers;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.x01ecommercegreedisgood.dtos.requests.CuponRequest;
import uni.edu.pe.x01ecommercegreedisgood.dtos.responses.MessageResponse;
import uni.edu.pe.x01ecommercegreedisgood.models.Cupon;
import uni.edu.pe.x01ecommercegreedisgood.services.CuponService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cupones")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @PostMapping("/")
    public ResponseEntity<MessageResponse> addCupon(@RequestBody CuponRequest cuponRequest) {
        return new ResponseEntity<>(cuponService.createCupon(cuponRequest), HttpStatus.CREATED);
    }
}
