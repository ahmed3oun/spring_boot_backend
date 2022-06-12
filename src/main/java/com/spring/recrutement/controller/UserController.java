package com.spring.recrutement.controller;

import com.spring.recrutement.Service.RoleService;
import com.spring.recrutement.Service.UserService;
import com.spring.recrutement.config.MyUserDetails;
import com.spring.recrutement.model.AuthRequest;
import com.spring.recrutement.model.Role;
import com.spring.recrutement.model.User;
import com.spring.recrutement.payload.UserRequest;
import com.spring.recrutement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private  UserService userService;
    public static final String IMG_ROOT_PATH = "F:\\ahmed\\work\\frontend-pfe-master\\src\\assets\\assets\\images\\users";
    public static final String default_img = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png";
    
    @Autowired
    RoleService roleService ;
    

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {

        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PostMapping(value =  "/add" )
    public ResponseEntity<?> addUser(  @RequestBody UserRequest user ) {
        
         Role role =  roleService.findRoleByNom(user.getRole());
        User newUser = userService.addUser(new User(  user.getEmail(), user.getUsername()
                            , user.getPassword(), default_img, role));
        
        return new ResponseEntity<>(newUser , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest user) {

        Role role =  roleService.findRoleByNom(user.getRole());
        User _user = userService.findUserById(user.getId());
        _user.setEmail(user.getEmail());
        _user.setUsername(user.getUsername());
        _user.setPassword(user.getPassword());
        _user.setRole(role);
        
        /* User _user = new User(  user.getEmail(), user.getUsername()
        , user.getPassword(), user.getImageUrl(), role);
        _user.setId(user.getId());  */
        User updateUser = userService.updateUser(_user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value  = "/updateimg" /* , consumes = MediaType.MULTIPART_FORM_DATA_VALUE  */)
    public ResponseEntity<?>  updateUserImg(@RequestParam("img") MultipartFile file 
                        , @RequestParam("user_id") String id  ) throws IllegalStateException, IOException  {
        Path filePath = Paths
                .get(IMG_ROOT_PATH +  "/" +id + "/" + LocalDate.now().toString() + file.getOriginalFilename())
                .toAbsolutePath().normalize();
        System.out.println("file path ****  " + filePath.toString() );
        Path fileStoragePath = Paths.get(IMG_ROOT_PATH + "/"+id).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file", e);
        }
        User user = userService.findUserById( Long.parseLong(id)) ;
        user.setImageUrl(  filePath != null ? "/"+id+"/"+LocalDate.now().toString() + file.getOriginalFilename() :  default_img );
        userService.updateUser(user);

        return new ResponseEntity<>("image profile is updated" , HttpStatus.OK);
    }

}
