package com.dawissem.biat.Controller;

import com.dawissem.biat.Dto.AuthenticationRequest;
import com.dawissem.biat.Dto.UserDto;
import com.dawissem.biat.Entity.User;
import com.dawissem.biat.Exception.AlreadyExistsException;
import com.dawissem.biat.Exception.BadCredentialExecption;
import com.dawissem.biat.Exception.UserNotFoundException;
import com.dawissem.biat.Mapper.UserMapper;
import com.dawissem.biat.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    @PostMapping("authenticate")
    public UserDto authenticate(@RequestBody AuthenticationRequest request) {
        Optional<User> o=userRepo.findByMatricule(request.getMatricule());
        if(o.isEmpty())
        {
            throw new UserNotFoundException("there is no user with this matricule ");
        }
        else if(Objects.equals(o.get().getPassword(), request.getPassword()))
        {
            return userMapper.toUserDto(o.get());
        }
        else
        {
            throw new BadCredentialExecption("Bad Credentials");
        }


    }
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {

        return  userRepo.findAll().stream().map(user -> userMapper.toUserDto(user)).toList();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Optional<User> existingUser = userRepo.findByMatricule(user.getMatricule());
        if (existingUser.isPresent()) {
            throw new AlreadyExistsException("user Already Exists");
        }
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
       Optional<User >o= userRepo.findById(id);
       if(o.isEmpty())
           throw new UserNotFoundException("User not found");
       User user=o.get();
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setMail(userDetails.getMail());
        user.setPassword(userDetails.getPassword());
        user.setAgence(userDetails.getAgence());



        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");



    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
