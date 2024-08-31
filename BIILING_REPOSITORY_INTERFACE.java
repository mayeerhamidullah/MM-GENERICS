package com.BILLING.REPOSITORY;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BILLING.ENTITY.ENTITYCLASS;


@Repository
public interface BIILING_REPOSITORY_INTERFACE extends CrudRepository<ENTITYCLASS,Integer> {
	@Query("select ent from ENTITYCLASS ent where ent.phoneno= ?1")
	public List<ENTITYCLASS> findAll(String keyword);
}