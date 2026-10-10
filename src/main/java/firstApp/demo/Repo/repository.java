package firstApp.demo.Repo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import firstApp.demo.donner.donner;
import firstApp.demo.donner.donnerDao;
import firstApp.demo.donner.districts;
import firstApp.demo.donner.districtsDto;
import jakarta.persistence.*;

import jakarta.persistence.Query;
import jakarta.transaction.Transactional;



@Repository
public class repository {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	
//	 public repository(EntityManager entityManager) {
//	        this.entityManager = entityManager;
//	    }
	
	 @Transactional
	public String saveDonner(donner Donner) {
		 entityManager.merge(Donner);
		return "Donner Saved";
	}

	public List<donner> viewList() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery(" from donner",donner.class);
		
		return query.getResultList();
	}

	

	public List<districtsDto> getMand(Integer id) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select district_id,district_name ,mandals from districts where 1=1 ");
		if(id!=null) sql.append(" and district_id=:id ");
		Query query=entityManager.createQuery(sql.toString()); 
		if(id!=null) query.setParameter("id" ,id );
		List<Object []> list=query.getResultList();
		List<districtsDto> result=new ArrayList<>();
		for(Object[] dist:list) {
			districtsDto dis=new districtsDto();
			dis.setId((Integer)dist[0]);
			dis.setState_name((String) dist[1]);
			dis.setMandals(((String) dist[2]).split(","));
			result.add(dis);
		}
		return result;	}

	public donner viewDonner(int id) {
		
		return entityManager.find(donner.class, id);
	}

	public List<donnerDao> getDonners(String distName,String mandal,Integer grp,Integer id) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer(" select d_name,ss.code_Desc as grpName,d_contact,d_mandal,d_district,dd.id,dd.d_group from donner dd join districts\r\n"
				+ "on district_name=d_district join systemCodes ss on ss.code_id=100 and code_val=d_group where 1=1  ");
		if(distName!=null) hql.append(" and district_name=:dName");
		if(mandal !=null) hql.append(" and d_mandal=:md");
		if(grp !=null) hql.append(" and d_group=:gp");
		if(id !=null) hql.append(" and dd.id=:uid");
		Query query =entityManager.createQuery(hql.toString());
		if(distName!=null) query.setParameter("dName",distName);
		if(mandal!=null) query.setParameter("md",mandal);
		if(grp!=null) query.setParameter("gp",grp);
		if(id!=null) query.setParameter("uid",id);
		List<Object []> list =query.getResultList();
		List<donnerDao> result=new ArrayList<>();
		for(Object [] tmp:list ) {
			donnerDao don=new donnerDao();
			don.setDonnerName((String)tmp[0]);
			don.setGroupName((String)tmp[1]);
			don.setContact((String)tmp[2]);
			don.setMandal((String)tmp[3]);			
			don.setDistrictName((String)tmp[4]);
			don.setId((Integer)tmp[5]);
			don.setGroupId((Integer)tmp[6]);
			result.add(don);
		}
		return result;
	}
}
