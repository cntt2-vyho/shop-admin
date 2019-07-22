package vn.edu.leading.shop.controllers.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.SupplierDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.services.SupplierService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierApiController {

    private SupplierService supplierService;

    public SupplierApiController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierModel>> list() {
        return new ResponseEntity(supplierService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierModel> findById(@PathVariable Long id) {
        SupplierModel supplierModel = supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("supplier"));
        return new ResponseEntity(supplierModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SupplierModel> save(@RequestBody SupplierDTO dto) {
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setSupplierName(dto.getSupplierName());
        supplierModel.setContactName(dto.getContactName());
        supplierModel.setAddress(dto.getAddress());
        supplierModel.setCity(dto.getCity());
        supplierModel.setPostalCode(dto.getPostalCode());
        supplierModel.setCountry(dto.getCountry());
        supplierModel.setPhone(dto.getPhone());
        return new ResponseEntity(supplierService.save(supplierModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierModel> update(@PathVariable Long id, @Valid @RequestBody SupplierDTO dto) {
        SupplierModel supplierModel = supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("supplier"));
        supplierModel.setSupplierName(dto.getSupplierName());
        supplierModel.setContactName(dto.getContactName());
        supplierModel.setAddress(dto.getAddress());
        supplierModel.setCity(dto.getCity());
        supplierModel.setPostalCode(dto.getPostalCode());
        supplierModel.setCountry(dto.getCountry());
        supplierModel.setPhone(dto.getPhone());
        return new ResponseEntity(supplierService.save(supplierModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        supplierService.findById(id).orElseThrow(() -> new ObjectNotFoundException("supplier"));
        return new ResponseEntity<>(supplierService.delete(id), HttpStatus.OK);
    }
}
