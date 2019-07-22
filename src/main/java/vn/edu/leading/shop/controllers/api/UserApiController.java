package vn.edu.leading.shop.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.leading.shop.controllers.api.dto.UserDTO;
import vn.edu.leading.shop.errors.ObjectNotFoundException;
import vn.edu.leading.shop.models.UserModel;
import vn.edu.leading.shop.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserModel>> list() {
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
        UserModel userModel = userService.findById(id).orElseThrow(() -> new ObjectNotFoundException("user"));
        return new ResponseEntity(userModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody UserDTO dto) {
        UserModel userModel = new UserModel();
        userModel.setUsername(dto.getUsername());
        userModel.setPassword(dto.getPassword());
        return new ResponseEntity<>(userService.save(userModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        UserModel userModel = userService.findById(id).orElseThrow(() -> new ObjectNotFoundException("user"));
        userModel.setUsername(dto.getUsername());
        userModel.setPassword(dto.getPassword());
        return new ResponseEntity(userService.save(userModel),HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.findById(id).orElseThrow(() -> new ObjectNotFoundException("user"));
        return new ResponseEntity(userService.delete(id), HttpStatus.OK);
    }
}
