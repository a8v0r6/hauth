package com.secure.hauth.repository;

import com.secure.hauth.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    public Optional<UserModel> findByEmail(String email);
}
