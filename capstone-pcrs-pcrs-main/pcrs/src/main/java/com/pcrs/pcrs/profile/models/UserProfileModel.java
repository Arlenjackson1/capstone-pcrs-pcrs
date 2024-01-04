package com.pcrs.pcrs.profile.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;

    @Lob
    private byte[] profileImage;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @ManyToMany
    @JoinTable(name = "user_followers", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "follower_id"))
    @JsonIgnore
    private List<UserModel> followers;

    @ManyToMany
    @JoinTable(name = "user_following", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    @JsonIgnore
    private List<UserModel> following;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<UserPost> posts;

    @Lob
    private byte[] setupImage;

    private String setupDescription;

   
    public UserProfileModel() {
        
    }

   
    public UserProfileModel(UserModel user) {
        this.user = user;
    }


    public UserModel getUser() {
        return user;
    }


    public void setUser(UserModel user) {
        this.user = user;
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


    public List<UserModel> getFollowers() {
        return followers;
    }


    public void setFollowers(List<UserModel> followers) {
        this.followers = followers;
    }


    public List<UserModel> getFollowing() {
        return following;
    }


    public void setFollowing(List<UserModel> following) {
        this.following = following;
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
