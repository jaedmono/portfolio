package com.twitter.portfolio.service;

import com.twitter.portfolio.model.PortfolioRequest;
import com.twitter.portfolio.model.ProfileResponse;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface ProfileService {

    ProfileResponse retrieveUserProfile(BigInteger profileUserId);

    ProfileResponse updateUserProfile(PortfolioRequest portfolioRequest );
}
