package com.pcrs.pcrs.profile.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcrs.pcrs.profile.models.UserProfileModel;

public interface UserProfileRepository extends JpaRepository<UserProfileModel, Long> {
    UserProfileModel findByUser_Username(String username);
}
