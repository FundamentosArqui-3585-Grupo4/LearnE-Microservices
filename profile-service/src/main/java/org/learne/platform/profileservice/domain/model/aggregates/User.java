package org.learne.platform.profileservice.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.learne.platform.profileservice.domain.model.commands.CreateUserCommand;
import org.learne.platform.profileservice.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Integer type_user;

    @Column
    private Integer type_plan;

    public User() {}

    public User updateUser(String firstName, String lastName, String username, String email, String password, Integer type_user, Integer type_plan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.type_user = type_user;
        this.type_plan = type_plan;
        return this;
    }

    public User(CreateUserCommand command) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.username = command.username();
        this.email = command.email();
        this.password = command.password();
        this.type_user = command.typeUser();
        this.type_plan = command.type_plan();
    }
    public User(Long id) {setId(id);}

    public void setPublicId(Long id) {
        this.setId(id);
    }
}
