package com.twitter.portfolio.controller;

import com.twitter.portfolio.exception.ProfileAuthorizationException;
import com.twitter.portfolio.model.PortfolioRequest;
import com.twitter.portfolio.model.ProfileCreateResponse;
import com.twitter.portfolio.model.ProfileResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.Map;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/profiles")
public interface PortfolioController {


    @GetMapping("/{profileUserId}")
    @ResponseStatus(OK)
    ProfileResponse retrievePortfolio(
            @RequestHeader Map<String, String> headers, @PathVariable BigInteger profileUserId)
            throws ProfileAuthorizationException;

    @PutMapping("/")
    @ResponseStatus(OK)
    ProfileResponse updatePortfolio(
            @RequestHeader Map<String, String> headers,
            HttpServletResponse response,
            @RequestBody @Valid PortfolioRequest interviewCreateRequest)
            throws ProfileAuthorizationException;


}
