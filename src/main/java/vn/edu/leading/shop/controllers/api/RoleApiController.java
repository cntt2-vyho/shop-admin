package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.RoleDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.RoleModel;
import vn.edu.leading.shop.services.RoleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleApiController {
    private final RoleService roleService;

    public RoleApiController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleModel>> list() {
        return new ResponseEntity(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleModel> findById(@PathVariable Long id) {
        RoleModel roleModel = roleService.findById(id).orElseThrow(() -> new ObjectNotFoundException("role"));
        return new ResponseEntity(roleModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleModel> save(@RequestBody RoleDTO dto) {
        RoleModel roleModel = new RoleModel();
        roleModel.setName(dto.getName());
        return new ResponseEntity(roleService.save(roleModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleModel> update(@PathVariable Long id, @Valid @RequestBody RoleDTO dto) {
        RoleModel roleModel = roleService.findById(id).orElseThrow(() -> new ObjectNotFoundException("role"));
        roleModel.setName(dto.getName());
        return new ResponseEntity(roleService.save(roleModel),HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roleService.findById(id).orElseThrow(() -> new ObjectNotFoundException("role"));
        return new ResponseEntity(roleService.delete(id), HttpStatus.OK);
    }
}
