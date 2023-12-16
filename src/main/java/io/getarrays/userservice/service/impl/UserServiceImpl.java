/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 12:26 PM
 * Project Name: userservice
 */

package io.getarrays.userservice.service.impl;

import io.getarrays.userservice.model.Confirmation;
import io.getarrays.userservice.model.User;
import io.getarrays.userservice.repository.ConfirmationRepository;
import io.getarrays.userservice.repository.UserRepository;
import io.getarrays.userservice.service.EmailService;
import io.getarrays.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;


    @Override
    public User saveUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) throw new RuntimeException("Email already exist");

        user.setIsEnabled(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

        // TODO  Send email to user with Token
        emailService.sendSimpleMailMessage(user.getName(),user.getEmail(),confirmation.getToken());


        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);

        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setIsEnabled(true);
        userRepository.save(user);

//        confirmationRepository.delete(confirmation);

        return Boolean.TRUE;
    }
}
