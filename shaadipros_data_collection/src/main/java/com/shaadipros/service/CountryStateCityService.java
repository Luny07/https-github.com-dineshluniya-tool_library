package com.shaadipros.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaadipros.dao.CityDao;
import com.shaadipros.dao.StateDao;
import com.shaadipros.entity.City;
import com.shaadipros.entity.Country;
import com.shaadipros.entity.State;



@Service
public class CountryStateCityService {

	@Autowired
	private CityDao citydao;
	
	@Autowired
	private StateDao statedao;
	
	String line = "";
	
	public void SaveCityrecords() throws IOException
	{
		
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/City.csv"));
			while((line=br.readLine())!=null)
			{
				
				String [] data = line.split(",");
				
				String cname = data[0];
				String stateid = data[1];
				String createdBy = data[2];
				//String createddate = data[3];
				String isdeleted = data[4];
				//String modifieddate = data[5];
				String isactive = data[4];
				
				City c = new City();
				State s = new State();
				
				c.setName(cname);
				s.setId(Integer.parseInt(stateid));
				c.setCreatedBy(createdBy);
				//c.setCreatedDate(new Date(createddate));
				c.setCreatedDate(new Date());
				c.setDeleted(Boolean.parseBoolean(isdeleted));
				//c.setModifiedDate(new Date(modifieddate));
				c.setModifiedDate(new Date());
				c.setActive(Boolean.parseBoolean(isactive));
				citydao.save(c);
		    
			}
				
			
			}

	public void SaveStaterecords() throws IOException 
	{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/State.csv"));
		
		while((line=br.readLine())!=null)
		{
			
			String [] data = line.split(",");
			
			String sname = data[0];
			String countryid = data[1];
			String createdby = data[2];
			String createddate = data[3];
			String isdeleted = data[4];
			String modifieddate = data[5];
			String slug = data[6];
			String isactive = data[7];
			
			City c = new City();
			State s = new State();
			Country country = new Country();
			
			s.setsName(sname);
			country.setCountryCode(Integer.parseInt(countryid));
			s.setCreatedBy(createdby);
			s.setCreatedDate(new Date());
			s.setDeleted(Boolean.parseBoolean(isdeleted));
			s.setModifiedDate(new Date());
			s.setSlug(slug);
			s.setActive(Boolean.parseBoolean(isactive));
			statedao.save(s);
			
			
		}
		}
		
		public void SaveCountryrecords() throws IOException 
		{
			// TODO Auto-generated method stub
			
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Country.csv"));
			
			while((line=br.readLine())!=null)
			{
				
				String [] data = line.split(",");
				
				String countryname = data[0];
				String stateid = data[1];
				String createdby = data[2];
				String createddate = data[3];
				String isdeleted = data[4];
				String modifieddate = data[5];
				String slug = data[6];
				String isactive = data[7];
				
				
				
				
		    
			}
}
		
		public void SaveStateZiprecords() throws IOException 
		{
			// TODO Auto-generated method stub
			
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/StateZIP.csv"));
			
			while((line=br.readLine())!=null)
			{
				
				String [] data = line.split(",");
				
				String zipcode = data[0];
				String cityid = data[1];
				String createdby = data[2];
				String createddate = data[3];
				String isdeleted = data[4];
				String modifieddate = data[5];
				String slug = data[6];
				String isactive = data[7];
				
				
				
				
		    
			}
}
		

}