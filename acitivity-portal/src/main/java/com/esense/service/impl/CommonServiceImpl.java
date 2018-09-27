package com.esense.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esense.dao.CommonDao;
import com.esense.service.CommonService;
	
@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;
	
	@Transactional
	@Override
	public void save(Object object) {
		commonDao.save(object);
		
	}


	@Transactional
	@Override
	public void updateObject(Object object) {
		commonDao.updateObject(object);
	}

	@Transactional
	@Override
	public List getListByObject(Class Object) {
		return commonDao.getListByObject(Object);
	}

	@Transactional
	@Override
	public Object getObjectById(Class Object, int id) {
		// TODO Auto-generated method stub
		return commonDao.getObjectById(Object, id);
	}

	@Transactional
	@Override
	public void removeObjectById(Class Object, int id) {
		commonDao.removeObjectById(Object, id);
	}
	
	@Transactional
	@Override
	public List getListByQuery(String query) {
		return commonDao.getListByQuery(query) ;
	}

}
