package edu.mum.waa.validators;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.waa.services.UserService;

public class UserEmailValidator implements ConstraintValidator<UserEmail, String>{
	
	@Autowired
	private UserService userService;

	public void initialize(UserEmail constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {        
        return userService.searchByEmail(value) == null;
	}
}
