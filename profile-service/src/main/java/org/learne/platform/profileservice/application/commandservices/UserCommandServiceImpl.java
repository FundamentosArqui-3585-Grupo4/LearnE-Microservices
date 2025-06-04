package org.learne.platform.profileservice.application.commandservices;

import org.learne.platform.profileservice.domain.model.aggregates.User;
import org.learne.platform.profileservice.domain.model.commands.CreateUserCommand;
import org.learne.platform.profileservice.domain.model.commands.UpdateUserCommand;
import org.learne.platform.profileservice.domain.services.UserCommandService;
import org.learne.platform.profileservice.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        var result = userRepository.findById(command.userId());
        if (result.isEmpty()) {
            throw new IllegalArgumentException("An user with id " + command.userId() + " does not exist");
        }
        var userToUpdate = result.get();
        try {
            var updateUser = userRepository.save(userToUpdate.updateUser(command.firstName(), command.lastName(),
                    command.username(), command.email(), command.password(), command.typeUser(), command.type_plan()));
            return Optional.of(userToUpdate);
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while updating the user " + e.getMessage());
        }
    }
    @Override
    public Long handle(CreateUserCommand command) {
        if (userRepository.existsByUsernameAndEmail(command.username(), command.email())) {
            throw new IllegalArgumentException("username and email already exists with a user");
        }
        var newUser = new User(command);
        try {
            User savedUser = userRepository.save(newUser);
            return savedUser.getId();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("An error occurred while saving the user " + e.getMessage());
        }
    }
}
