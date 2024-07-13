package com.LeoDuarte37.ForgotPassword_Api.repository;

import com.LeoDuarte37.ForgotPassword_Api.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
}
