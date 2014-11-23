package com.project.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.hibernate.entity.Acthors;
import com.project.hibernate.entity.Employments;
import com.project.hibernate.entity.Spectacles;

@Repository

public class DAOImplementation  implements DAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	 

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DAOImplementation() {
		System.out.println("fuck");
	}

	public Session getCurrentSesion(){
		return this.sessionFactory.getCurrentSession();
	}
	@Transactional
	@Override
	public void save(Object instance, Class<?> type) {
	     if(type == Acthors.class){
	    	 Acthors acthors = (Acthors) instance;
	    	 this.getCurrentSesion().save(acthors);
	     } 
	     if(type == Spectacles.class){
	    	 Spectacles spectacles = (Spectacles) instance;
	    	 this.getCurrentSesion().save(spectacles);
	     } 
	     if(type == Employments.class){
	    	 Employments employments = (Employments) instance;
	    	 this.getCurrentSesion().save(employments);
	     } 
	}

	@Transactional
	@Override
	public List getAll(Class<?> type) {
		return this.getCurrentSesion().createCriteria(type).list();
	}
	@Transactional
	@Override
	public List makeQuery(String sqlQuery,Class<?> type) {
		// TODO Auto-generated method stub
		return this.getCurrentSesion().createSQLQuery(sqlQuery).addEntity(type).list();
	}
	@Transactional
	@Override
	public void update(Object instance, Class<?> type) {
		 if(type == Acthors.class){
	    	 Acthors acthors = (Acthors) instance;
	    	 this.getCurrentSesion().update(acthors);
	     } 
	     if(type == Spectacles.class){
	    	 Spectacles spectacles = (Spectacles) instance;
	    	 this.getCurrentSesion().update(spectacles);
	     } 
	     if(type == Employments.class){
	    	 Employments employments = (Employments) instance;
	    	 this.getCurrentSesion().update(employments);
	     } 
		
	}
	@Transactional
	@Override
	public void delete(Object instance, int id, Class<?> type) {
		 if(type == Acthors.class){
	    	 Acthors acthors = (Acthors) instance;
	    	 
	    	 this.getCurrentSesion().delete(acthors);
	     } 
	     if(type == Spectacles.class){
	    	 Spectacles spectacles = (Spectacles) instance;
	    	  
	    	 this.getCurrentSesion().delete(spectacles);
	     } 
	     if(type == Employments.class){
	    	 Employments employments = (Employments) instance;
	    	 this.getCurrentSesion().delete(employments);
	     } 
	}
}
