package com.esense.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esense.dao.CommonDao;

@Repository
public class CommonDaoImpl implements CommonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveObject(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

}
