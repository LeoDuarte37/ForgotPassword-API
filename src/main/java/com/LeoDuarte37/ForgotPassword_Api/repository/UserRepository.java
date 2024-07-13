package com.LeoDuarte37.ForgotPassword_Api.repository;

import com.LeoDuarte37.ForgotPassword_Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
