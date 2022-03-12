package com.twitter.portfolio.controller;

import com.twitter.portfolio.exception.ProfileAuthorizationException;
import com.twitter.portfolio.model.PortfolioCreateRequest;
import com.twitter.portfolio.model.PortfolioRequest;
import com.twitter.portfolio.model.ProfileCreateResponse;
import com.twitter.portfolio.model.ProfileResponse;
import com.twitter.portfolio.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class PortfolioControllerImpl implements PortfolioController{

    private ProfileService profileService;

    @Override
    public ProfileResponse retrievePortfolio(
            Map<String, String> headers,
            BigInteger profileUserId) throws ProfileAuthorizationException {
        return profileService.retrieveUserProfile(profileUserId);
    }

    @Override
    public ProfileResponse updatePortfolio(
            Map<String, String> headers,
            HttpServletResponse response,
            PortfolioRequest portfolioRequest) throws ProfileAuthorizationException {
        return profileService.updateUserProfile(portfolioRequest);
    }


}
