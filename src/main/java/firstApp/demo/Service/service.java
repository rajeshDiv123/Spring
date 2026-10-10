package firstApp.demo.Service;

import java.util.*;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

import firstApp.demo.Repo.repository;
import firstApp.demo.donner.districts;
import firstApp.demo.donner.districtsDto;
import firstApp.demo.donner.donner;
import firstApp.demo.donner.donnerDao;


@Service
public class service {
	@Autowired
	Student temp;
	@Autowired
	repository repo;
	
	public List<donner> viewList(){
		
		
		return repo.viewList();
	}
	
	public String createDonner(donner body) {
		return repo.saveDonner(body);
	}

	

	public List<districtsDto> getMand(Integer id) {
		
		
		return repo.getMand(id);
	}
	
	@Cacheable("myCache")
	public donner viewDonner(int id) {
		// TODO Auto-generated method stub
		donner theDonner=repo.viewDonner(id);
		
		return theDonner;
	}

	public List<donnerDao> getDonner(String dist,String mandal,Integer grp,Integer id) {
		// TODO Auto-generated method stub
		return repo.getDonners(dist,mandal,grp,id);
	}

	

}
