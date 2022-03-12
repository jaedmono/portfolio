package com.twitter.portfolio.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProfileResponse {

    private String experience;
    private String imagePath;
    private String name;
    private String twitterUser;
    private String email;
    private String address;
    private String phone;
    private String zipCode;
    private String secondImagePath;
    private String secondTwitterUser;
    private String secondZipCode;
}
