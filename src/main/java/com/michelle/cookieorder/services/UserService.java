package com.michelle.cookieorder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.repositories.RoleRepository;
import com.michelle.cookieorder.repositories.UserRepository;



@Service
public class UserService {
	
 
	@Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
//    // TO-DO: Write register and login methods!
//    public User register(User newUser, BindingResult result) {
//        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
//        
//        //check email
//        if(potentialUser.isPresent()) {
//        	result.rejectValue("email", "unique", "The email already exists");
//        }
//        // check if passwords match
//        if(!newUser.getPassword().equals(newUser.getConfirm())) {
//        	result.rejectValue("password", "matches", "The passwords don't match");
//        }
//        if(result.hasErrors()) {
//        	  return null;
//        }
//       String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
//       newUser.setPassword(hashed);
//       return userRepo.save(newUser);
//    }
//    
//    
//    public User login(LoginUser newLogin, BindingResult result) {
//    	// find user
//    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
//    	//reject if it doesn't exist
//    	if(!potentialUser.isPresent()) {
//    		result.rejectValue("email","unique","Email doesn't exist" );
//    		return null;
//    	}
//    	
//    	//get from DB
//    	User user = potentialUser.get();
//    	//check PW
//		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
//		    result.rejectValue("password", "matches", "Invalid Password!");
//		}
//        if(result.hasErrors()) {
//        	return null;
//        }
//        return user;
//    }
//    
    public User getUser(Long id) {
    	Optional<User> optionalUser = userRepository.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	}else {
    		return null;
    	}
    }
}

