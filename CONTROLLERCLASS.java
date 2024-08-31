package com.BILLING.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BILLING.ENTITY.ENTITYCLASS;
import com.BILLING.REPOSITORY.BIILING_REPOSITORY_INTERFACE;
import com.BILLING.SERVICE.billingserviceclass;


import jakarta.transaction.Transactional;


@Controller
public class CONTROLLERCLASS {
	
	@Autowired
	private billingserviceclass billserv;
	
	@Autowired
	private BIILING_REPOSITORY_INTERFACE myrepo;
	
	@GetMapping("/retrebyPHONENO")
	 public ModelAndView gettab(@Param("keyword") String keyword)
	 {
	 
Iterable<ENTITYCLASS> list=billserv.listAll(keyword);
		
		return new ModelAndView("retrebyPHONENO","ENTITYCLASS",list);
	 }
	
}
