package com.esense.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.esense.dao.CommonDao;
import com.esense.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired(required=true)
	private CommonDao commonDao;
	
	@Transactional
	@Override
	public void saveObject(Object object) {	
		commonDao.saveObject(object);
	}

}
