package com.michelle.cookieorder.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.repositories.UserRepository;

@Component
public class UserValidator implements Validator {

//	@Autowired
//	private UserRepository userRepository;

	// 1
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	// 2
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		if (!user.getConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
//		Optional<User> potentialEmail = userRepository.findByEmail(user.getEmail());
//		if (potentialEmail.isPresent()) {
//			errors.rejectValue("emailExists", "Unique");
//		}
//		Optional<User> potentialUser = userRepository.findByUsername(user.getUsername());
//		if (potentialUser.isPresent()) {
//			errors.rejectValue("usernameExists", "Unique");
//		}
	}

}
