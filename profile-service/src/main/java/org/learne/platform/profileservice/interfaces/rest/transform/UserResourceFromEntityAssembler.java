package org.learne.platform.profileservice.interfaces.rest.transform;

import org.learne.platform.profileservice.domain.model.aggregates.User;
import org.learne.platform.profileservice.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource ToResourceFromEntity(User entity){
        return new UserResource(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getType_user(), entity.getType_plan());
    }
}
