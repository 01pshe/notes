package com.vol.notes.validator;

import com.vol.notes.model.User;
import com.vol.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","Required");
        if (user.getName().length()<8||user.getName().length()>32){
            errors.rejectValue("name","Size.userForm.userName");
        }
        if (userService.findByName(user.getName())!=null){
            errors.rejectValue("name","Duplicate.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required");
        if (user.getPassword().length()<8||user.getPassword().length()>32){
            errors.rejectValue("name","Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword","Different.userForm.password");
        }

    }
}
