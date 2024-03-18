package com.dev.biblioteca.modules.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.biblioteca.modules.configs.erros.ResourceNotFoundException;
import com.dev.biblioteca.modules.users.dto.CreateUserDTO;
import com.dev.biblioteca.modules.users.dto.ReturnUserDTO;
import com.dev.biblioteca.modules.users.dto.UpdateUserDTO;
import com.dev.biblioteca.modules.users.types.UsersTypes;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    
    public List<ReturnUserDTO> findAll() {
        List<UserEntity> users = this.usersRepository.findAll();

        List<ReturnUserDTO> usersDTO = new ArrayList<>();

        for(UserEntity user : users){
            ReturnUserDTO userDTO = new ReturnUserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setUsersType(user.getUsersType());
            userDTO.setCreatedAt(user.getCreatedAt());
            userDTO.setUpdatedAt(user.getUpdatedAt());
            
            usersDTO.add(userDTO);
        }

        return usersDTO;
    }

    public ReturnUserDTO findById(UUID id) {
        Optional<UserEntity> user = this.usersRepository.findById(id);
        
        if(!user.isPresent()){
            throw new ResourceNotFoundException("Id do usuario não exixte");
        }

        ReturnUserDTO userDTO = new ReturnUserDTO();
        userDTO.setId(user.get().getId());
        userDTO.setName(user.get().getName());
        userDTO.setEmail(user.get().getEmail());
        userDTO.setUsersType(user.get().getUsersType());
        userDTO.setCreatedAt(user.get().getCreatedAt());
        userDTO.setUpdatedAt(user.get().getUpdatedAt());
        
        return userDTO;
    }

    public ReturnUserDTO findByEmail(String email) {
        Optional<UserEntity> user = this.usersRepository.findByEmail(email);
        
        if(!user.isPresent()){
            throw  new ResourceNotFoundException("Email não encontrado");
        }
        
        ReturnUserDTO userDTO = new ReturnUserDTO();
        userDTO.setId(user.get().getId());
        userDTO.setName(user.get().getName());
        userDTO.setEmail(user.get().getEmail());
        userDTO.setUsersType(user.get().getUsersType());
        userDTO.setCreatedAt(user.get().getCreatedAt());
        userDTO.setUpdatedAt(user.get().getUpdatedAt());
        
        return userDTO;
    }
        


    public ReturnUserDTO create(CreateUserDTO create) {
        UserEntity createUser = new UserEntity();
        
        Optional<UserEntity> userByEmail = this.usersRepository.findByEmail(create.getEmail());


        if(userByEmail.isPresent()){
            throw  new ResourceNotFoundException("Email não disponivel");
        }

        createUser.setId(UUID.randomUUID());
        createUser.setName(create.getName());
        createUser.setEmail(create.getEmail());
        createUser.setUsersType(UsersTypes.STUDENT);
        
        createUser.setHashPassword(create.getPassword());
        
       createUser =  this.usersRepository.save(createUser);

       ReturnUserDTO createdUserDTO = new ReturnUserDTO();
       createdUserDTO.setId(createUser.getId());
       createdUserDTO.setName(createUser.getName());
       createdUserDTO.setEmail(createUser.getEmail());
       createdUserDTO.setUsersType(createUser.getUsersType());
       createdUserDTO.setCreatedAt(createUser.getCreatedAt());
       createdUserDTO.setUpdatedAt(createUser.getUpdatedAt());

       return createdUserDTO;
    }


    public ReturnUserDTO update(UUID id, UpdateUserDTO update) {
        UserEntity user = this.usersRepository.findById(id).get();  
        
        if(user == null){
            return null;
        }
        
        if(update.getName() != null){
            user.setName(update.getName());
        }

        if(update.getEmail() != null){
            user.setEmail(update.getEmail());
        }

        this.usersRepository.save(user);

        ReturnUserDTO updatedUserDTO = new ReturnUserDTO();
        updatedUserDTO.setId(user.getId());
        updatedUserDTO.setName(user.getName());
        updatedUserDTO.setEmail(user.getEmail());
        updatedUserDTO.setUsersType(user.getUsersType());
        updatedUserDTO.setCreatedAt(user.getCreatedAt());
        updatedUserDTO.setUpdatedAt(user.getUpdatedAt());

        return updatedUserDTO;
    }


    
    public String delete(UUID id) {
     UserEntity user = this.usersRepository.findById(id).get();
     
     if(user == null){
         return null;
     }
     
     this.usersRepository.delete(user);
     
     return "User deleted";
    }

}
