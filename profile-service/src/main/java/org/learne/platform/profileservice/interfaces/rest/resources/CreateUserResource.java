package org.learne.platform.profileservice.interfaces.rest.resources;

public record CreateUserResource(String firstName, String lastName, String username, String email,
                                 String password, Integer type_user, Integer type_plan) {
}
