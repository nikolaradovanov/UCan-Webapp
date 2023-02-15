package com.ovdebeli.ucan.repository;

import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(
            value = "SELECT quote_id FROM user_preferences up WHERE up.user_id = :#{#user.id}",
            nativeQuery = true)
    List<Long> findLikedQuotesId(@Param("user")User user);
}
