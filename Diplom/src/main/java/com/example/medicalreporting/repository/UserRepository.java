package com.example.medicalreporting.repository;

import com.example.medicalreporting.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    Optional<UserEntity> findById(Long id);

}
