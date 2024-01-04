package com.pcrs.pcrs.profile.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.pcrs.pcrs.profile.dto.UserProfileDto;
import com.pcrs.pcrs.profile.models.UserProfileModel;
import com.pcrs.pcrs.profile.repos.UserProfileRepository;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfileDto createProfile(UserProfileModel profile) {
        UserProfileModel newUser = userProfileRepository.save(profile);
        return convertToDto(newUser);
    }

    public List<UserProfileDto> getAllProfiles() {
        List<UserProfileModel> allUserProfiles = userProfileRepository.findAll();
        return convertAllToDto(allUserProfiles);
    }

    private List<UserProfileDto> convertAllToDto(List<UserProfileModel> userProfiles) {
        List<UserProfileDto> dtoList = new ArrayList<>();
        for (UserProfileModel userProfile : userProfiles) {
            UserProfileDto dto = convertToDto(userProfile);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public UserProfileDto getProfileByUsername(String username) {
        UserProfileModel userProfileModel = userProfileRepository.findByUser_Username(username);

        if (userProfileModel != null) {
            return convertToDto(userProfileModel);
        } else {

            return null;
        }
    }

    private UserProfileDto convertToDto(UserProfileModel userProfileModel) {
        UserProfileDto response = new UserProfileDto();
        response.setUsername(userProfileModel.getUser().getUsername());
        response.setProfileImage(userProfileModel.getProfileImage());
        response.setBio(userProfileModel.getBio());
        response.setSetupImage(userProfileModel.getSetupImage());
        response.setSetupDescription(userProfileModel.getSetupDescription());

        return response;
    }
}
