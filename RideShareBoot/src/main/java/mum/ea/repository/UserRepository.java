package mum.ea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.ea.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
