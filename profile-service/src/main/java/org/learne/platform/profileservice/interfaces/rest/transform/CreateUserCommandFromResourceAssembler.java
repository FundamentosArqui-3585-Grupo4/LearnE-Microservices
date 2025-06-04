package org.learne.platform.profileservice.interfaces.rest.transform;

import org.learne.platform.profileservice.domain.model.commands.CreateUserCommand;
import org.learne.platform.profileservice.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand ToCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.firstName(), resource.lastName(), resource.username(), resource.email(),
                resource.password(), resource.type_user(), resource.type_plan());
    }
}
