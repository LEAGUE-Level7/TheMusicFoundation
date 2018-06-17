package org.leagueofcole.musicFoundationProject.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TeacherValidator implements Validator {
    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Teacher.class.equals(aClass);
    }

    /**
     * requirements for teacher attributes when creating new teacher
     */
    @Override
    public void validate(Object o, Errors errors) {
        Teacher teacher = (Teacher) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (teacher.getUserName().length() < 6 || teacher.getUserName().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (teacherService.findByUserName(teacher.getUserName()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (teacher.getPassword().length() < 8 || teacher.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!teacher.getPasswordConfirm().equals(teacher.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}