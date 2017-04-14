package fr.polytech.business.validators;

/**
 * Polytech Marseille
 * Case 925 - 163, avenue de Luminy
 * 13288 Marseille CEDEX 9
 * <p>
 * Ce fichier est l'oeuvre d'eleves de Polytech Marseille. Il ne peut etre
 * reproduit, utilise ou modifie sans l'avis express de ses auteurs.
 */

/**
 * @author Sudreau
 */

import fr.polytech.business.User;
import fr.polytech.business.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@PropertySource("classpath:/validation.properties")
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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32)
            errors.rejectValue("username", "Size.userForm.username", "Veuillez utilisez entre 6 et 32 caracteres.");

        if (userService.findByUsername(user.getUsername()) != null)
            errors.rejectValue("username", "Duplicate.userForm.username", "Ce nom d'utilisateur n\\'est pas disponible.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32)
            errors.rejectValue("password", "Size.userForm.password", "Mot de passe trop petit (6 caracteres)");

        if (!user.getPasswordConfirm().equals(user.getPassword()))
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm", "Les mots de passe ne sont pas identiques.");
    }
}