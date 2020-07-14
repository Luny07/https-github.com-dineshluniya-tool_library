package com.shaadipros.dao;

import org.springframework.data.repository.CrudRepository;

import com.shaadipros.entity.City;
import com.shaadipros.entity.Country;


public interface CountryDao extends CrudRepository<Country, Integer>{

}
