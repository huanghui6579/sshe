package edu.hbmy.sshe.dao;

import java.io.Serializable;
import java.util.Map;

public interface BaseDao<T> {
	public Serializable save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T load(String hql);
	
	public T load(String hql, Object[] params);
	
	public T load(String hql, Map<String, ?> params);
}
