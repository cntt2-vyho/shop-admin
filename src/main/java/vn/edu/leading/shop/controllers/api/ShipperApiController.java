package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.ShipperDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.ShipperModel;
import vn.edu.leading.shop.services.ShipperService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shippers")
public class ShipperApiController {

    private final ShipperService shipperService;


    public ShipperApiController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping
    public ResponseEntity<List<ShipperModel>> list() {
        return new ResponseEntity(shipperService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShipperModel> findById(@PathVariable Long id) {
        ShipperModel shipperModel = shipperService.findById(id).orElseThrow(() -> new ObjectNotFoundException("shipper"));
        return new ResponseEntity(shipperModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShipperModel> save(@RequestBody ShipperDTO dto) {
        ShipperModel shipperModel = new ShipperModel();
        shipperModel.setShipperName(dto.getShipperName());
        shipperModel.setPhone(dto.getPhone());
        return new ResponseEntity(shipperService.save(shipperModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipperModel> update(@PathVariable Long id, @Valid @RequestBody ShipperDTO dto) {
        ShipperModel shipperModel = shipperService.findById(id).orElseThrow(() -> new ObjectNotFoundException("shipper"));
        shipperModel.setShipperName(dto.getShipperName());
        shipperModel.setPhone(dto.getPhone());
        return new ResponseEntity(shipperService.save(shipperModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        shipperService.findById(id).orElseThrow(() -> new ObjectNotFoundException("shipper"));
        return new ResponseEntity<>(shipperService.delete(id), HttpStatus.OK);
    }
}
