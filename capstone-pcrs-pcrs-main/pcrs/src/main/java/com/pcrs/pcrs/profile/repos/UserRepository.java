package com.pcrs.pcrs.profile.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pcrs.pcrs.profile.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}

