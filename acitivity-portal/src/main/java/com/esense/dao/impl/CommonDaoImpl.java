package com.esense.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esense.dao.CommonDao;

@Repository
public class CommonDaoImpl implements CommonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Object object) {
		this.sessionFactory.getCurrentSession().save(object);	
	}

	@Override
	public void updateObject(Object object) {
		this.sessionFactory.getCurrentSession().update(object);		
	}

	@Override
	public List getListByObject(Class Object) {
		return this.sessionFactory.getCurrentSession().createCriteria(Object).list();
	}

	@Override
	public Object getObjectById(Class Object, int id) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().load(Object, id);
	}

	@Override
	public void removeObjectById(Class Object, int id) {
		 Object object2=this.sessionFactory.getCurrentSession().load(Object, id);
		if(null != object2){
			this.sessionFactory.getCurrentSession().delete(object2);
		}
		
	}
	
	@Override
	public List getListByQuery(String query) {
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}

	
}
