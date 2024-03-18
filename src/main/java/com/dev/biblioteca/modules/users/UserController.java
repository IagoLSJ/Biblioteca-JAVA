package com.dev.biblioteca.modules.users;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.biblioteca.modules.users.dto.CreateUserDTO;
import com.dev.biblioteca.modules.users.dto.ReturnUserDTO;
import com.dev.biblioteca.modules.users.dto.UpdateUserDTO;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UsersService userService;

    @GetMapping("/")
    public List<ReturnUserDTO> findAll() {
        return this.userService.findAll();
    }
    @GetMapping("/{id}")
    public ReturnUserDTO findById(@RequestParam UUID id) {
        return this.userService.findById(id);
    }
    @PostMapping("/")
    public ReturnUserDTO create(@RequestBody CreateUserDTO create) {
        return this.userService.create(create);
    }
    @PutMapping("/{id}")
    public ReturnUserDTO update(@PathVariable UUID id, @RequestBody UpdateUserDTO update) {
        return this.userService.update(id, update);
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id){
        return this.userService.delete(id);
    }
    

}
