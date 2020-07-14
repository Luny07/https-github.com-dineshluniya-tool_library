package com.shaadipros.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaadipros.service.CountryStateCityService;

@RestController
public class CountrySateCityController {

	@Autowired
	CountryStateCityService countrystatecityservice;
	
	
	 @GetMapping(path = "/storecitydata")
	 public void savecityrecords() throws IOException
	{
		 countrystatecityservice.SaveCityrecords();
	}
	 
	 @GetMapping(path = "/storestatedata")
	 public void savestaterecords() throws IOException
	{
		 countrystatecityservice.SaveStaterecords();
	}
	 
	 @GetMapping(path = "/storecountrydata")
	 public void savecountryecords() throws IOException
	{
		 countrystatecityservice.SaveCountryrecords();
	}
	 
	 @GetMapping(path = "/storecountrydata")
	 public void savestateziprecords() throws IOException
	{
		 countrystatecityservice.SaveStateZiprecords();
	}
	 
}
