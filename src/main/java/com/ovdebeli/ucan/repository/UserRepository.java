package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
