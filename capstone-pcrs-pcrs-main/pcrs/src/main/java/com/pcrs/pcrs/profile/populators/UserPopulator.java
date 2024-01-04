package com.pcrs.pcrs.profile.populators;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.pcrs.pcrs.profile.models.UserModel;
import com.pcrs.pcrs.profile.models.UserProfileModel;
import com.pcrs.pcrs.profile.repos.UserProfileRepository;
import com.pcrs.pcrs.profile.repos.UserRepository;
import jakarta.annotation.Resource;

@Component
public class UserPopulator implements CommandLineRunner {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserProfileRepository userProfileRepository;

    public UserPopulator(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        UserModel brianOrtiz = new UserModel("Brian", "Ortiz", "18JUN1995", "briortiz95@hotmail.com", "BrianO95",
                "password123");
        userRepository.save(brianOrtiz);
        UserModel romanOrtiz = new UserModel("Roman", "Ortiz", "14JAN2018", "romanortiz95@hotmail.com", "RomanO95",
                "password123");
        userRepository.save(romanOrtiz);

        UserProfileModel brianProfile = new UserProfileModel(brianOrtiz);
        brianProfile.setBio("I am an aspiring software developer currently enrolled in a course to learn Java. I don't know much about computer specifications");
        
        brianProfile.setSetupDescription("High-performance gaming rig featuring powerful GPU, multi-core CPU, ample RAM, fast SSD storage, RGB lighting, liquid cooling, and high-refresh-rate monitor.");

        userProfileRepository.save(brianProfile);

        UserProfileModel romanProfile = new UserProfileModel(romanOrtiz);
        romanProfile.setBio("I am a five year old boy who loves YouTube, Roblox, Minecraft and lots of scary movies.");
        romanProfile.setSetupDescription("High-performance gaming rig featuring powerful GPU, multi-core CPU, ample RAM, fast SSD storage, RGB lighting, liquid cooling, and high-refresh-rate monitor.");

        userProfileRepository.save(romanProfile);
    }

}
