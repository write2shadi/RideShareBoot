package mum.ea.service;

import java.util.Collection;
import java.util.Optional;

import mum.ea.domain.User;
import mum.ea.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
