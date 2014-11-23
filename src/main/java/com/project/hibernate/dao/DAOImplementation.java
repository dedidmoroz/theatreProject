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
@Transactional
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

	@Override
	public List getAll(Class<?> type) {
		return this.getCurrentSesion().createCriteria(type).list();
	}

	@Override
	public List makeQuery(String hqlQuery) {
		// TODO Auto-generated method stub
		return this.getCurrentSesion().createQuery(hqlQuery).list();
	}

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

	@Override
	public void delete(Object instance, int id, Class<?> type) {
		 if(type == Acthors.class){
	    	 Acthors acthors = (Acthors) instance;
	    	 this.getCurrentSesion().get(type, id);
	    	 this.getCurrentSesion().delete(acthors);
	     } 
	     if(type == Spectacles.class){
	    	 Spectacles spectacles = (Spectacles) instance;
	    	 this.getCurrentSesion().get(type, id);
	    	 this.getCurrentSesion().delete(spectacles);
	     } 
	     if(type == Employments.class){
	    	 Employments employments = (Employments) instance;
	    	 this.getCurrentSesion().get(type, id);
	    	 this.getCurrentSesion().delete(employments);
	     } 
	}
}
