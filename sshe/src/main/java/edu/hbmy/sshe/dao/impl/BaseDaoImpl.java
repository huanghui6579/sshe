package edu.hbmy.sshe.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.hbmy.sshe.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T t) {
		return getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public T load(String hql) {
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public T load(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		if(ArrayUtils.isNotEmpty(params)) {
			for(int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public T load(String hql, Map<String, ?> params) {
		Query query = getSession().createQuery(hql);
		if(MapUtils.isNotEmpty(params)) {
			Set<String> keys = params.keySet();
			for(String key : keys) {
				query.setParameter(key, params.get(key));
			}
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

}
