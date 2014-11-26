package com.project.hibernate.dao;

import java.util.List;

public interface DAO {
	public void save(Object instance,Class<?> type);
	public List getAll(Class<?> type);
	public List makeQuery(String sqlQuery,Class<?> type);
	
	public void update(Object instance,Class<?> type);
	public void delete(Object instance,Long id,Class<?> type);
}
