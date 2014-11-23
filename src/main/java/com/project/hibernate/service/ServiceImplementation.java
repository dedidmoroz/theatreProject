package com.project.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hibernate.dao.DAO;


@Service
public class ServiceImplementation  implements com.project.hibernate.service.Service  {

	
	@Autowired
	private DAO dao;
	
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public ServiceImplementation() {
	 	 
	}

	@Override
	public void save(Object instance, Class<?> type) {
	    dao.save(instance, type);
	}

	@Override
	public List getAll(Class<?> type) {
		 
		return dao.getAll(type);
	}

	@Override
	public List makeQuery(String hqlQuery) {
		 
		return dao.makeQuery(hqlQuery);
	}

	@Override
	public void update(Object instance, Class<?> type) {
		dao.update(instance, type);
	}

	@Override
	public void delete(Object instance, int id, Class<?> type) {
		dao.delete(instance, id, type);	
	}
 
}
