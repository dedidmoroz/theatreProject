package com.project.hibernate.service;

import java.util.List;


public interface Service {
	public void save(Object instance,Class<?> type);
	public List getAll(Class<?> type);
	public List makeQuery(String hqlQuery);
	
	public void update(Object instance,Class<?> type);
	public void delete(Object instance,int id,Class<?> type);
}
