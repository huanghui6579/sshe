package edu.hbmy.sshe.dao;

import java.io.Serializable;

public interface BaseDao<T> {
	public Serializable save(T t);
	
	public void update(T t);
	
	public void delete(T t);
}
