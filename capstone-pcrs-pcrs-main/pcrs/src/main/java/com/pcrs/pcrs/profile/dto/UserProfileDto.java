package com.pcrs.pcrs.profile.dto;

public class UserProfileDto {
     private String username;
    private byte[] profileImage;
    private String bio;
    private byte[] setupImage;
    private String setupDescription;
    public UserProfileDto() {
    }
    public UserProfileDto(String username, byte[] profileImage, String bio, byte[] setupImage,
            String setupDescription) {
        this.username = username;
        this.profileImage = profileImage;
        this.bio = bio;
        this.setupImage = setupImage;
        this.setupDescription = setupDescription;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public byte[] getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public byte[] getSetupImage() {
        return setupImage;
    }
    public void setSetupImage(byte[] setupImage) {
        this.setupImage = setupImage;
    }
    public String getSetupDescription() {
        return setupDescription;
    }
    public void setSetupDescription(String setupDescription) {
        this.setupDescription = setupDescription;
    }
    
}
