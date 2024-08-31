package com.BILLING.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.BILLING.ENTITY.ENTITYCLASS;
import com.BILLING.REPOSITORY.BIILING_REPOSITORY_INTERFACE;


import jakarta.transaction.Transactional;

@Service
public class billingserviceclass {
	
	
	@Autowired
	BIILING_REPOSITORY_INTERFACE myrepo;
	
	@Autowired
	public void setMyrepo(BIILING_REPOSITORY_INTERFACE myrepo) {
		this.myrepo = myrepo;
	}
	public void register(ENTITYCLASS ent)
	{
		myrepo.save(ent);
	}
public Iterable<ENTITYCLASS> getAllTablets()
{
	return myrepo.findAll();
	
}
public Iterable<ENTITYCLASS> listAll(String keyword)
{
	if(keyword!=null)
	{
		return myrepo.findAll(keyword);
	}
	return myrepo.findAll();
}



}
