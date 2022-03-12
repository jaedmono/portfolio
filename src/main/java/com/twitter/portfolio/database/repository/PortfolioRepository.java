package com.twitter.portfolio.database.repository;

import com.twitter.portfolio.database.entity.PortfolioEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface PortfolioRepository extends CrudRepository<PortfolioEntity, BigInteger> {

}
