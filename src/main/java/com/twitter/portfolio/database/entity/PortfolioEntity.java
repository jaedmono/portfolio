package com.twitter.portfolio.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity(name = "portfolio")
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    private String experience;

    @Column(insertable = false, updatable = false)
    private String imagePath;
    private String name;

    @Column(insertable = false, updatable = false)
    private String twitterUser;
    private String email;
    private String address;
    private String phone;

    @Column(insertable = false, updatable = false)
    private String zipCode;

    @Column(name = "imagePath")
    private String secondImagePath;

    @Column(name = "twitterUser")
    private String secondTwitterUser;

    @Column(name = "zipCode")
    private String secondZipCode;
}
