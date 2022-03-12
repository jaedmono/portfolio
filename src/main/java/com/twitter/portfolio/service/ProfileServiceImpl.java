package com.twitter.portfolio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.portfolio.database.entity.PortfolioEntity;
import com.twitter.portfolio.database.repository.PortfolioRepository;
import com.twitter.portfolio.model.PortfolioRequest;
import com.twitter.portfolio.model.ProfileResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService{

    private PortfolioRepository repository;

    @Override
    public ProfileResponse retrieveUserProfile(BigInteger idUserProfile) {
        Optional<PortfolioEntity> entity = repository.findById(idUserProfile);
        return getResponse(entity.isPresent()? entity.get(): new PortfolioEntity());
    }

    @Override
    public ProfileResponse updateUserProfile(PortfolioRequest portfolioRequest) {
        PortfolioEntity entity = repository.save(new ObjectMapper().convertValue(portfolioRequest, PortfolioEntity.class));
        return getResponse(entity);
    }

    private ProfileResponse getResponse(PortfolioEntity entity){
        return ProfileResponse.builder()
                .address(entity.getAddress())
                .email(entity.getEmail())
                .name(entity.getName())
                .experience(entity.getExperience())
                .imagePath(entity.getImagePath())
                .twitterUser(entity.getTwitterUser())
                .zipCode(entity.getZipCode())
                .secondZipCode(entity.getSecondZipCode())
                .secondTwitterUser(entity.getSecondTwitterUser())
                .secondImagePath(entity.getSecondImagePath())
                .phone(entity.getPhone())
                .build();
    }
}
