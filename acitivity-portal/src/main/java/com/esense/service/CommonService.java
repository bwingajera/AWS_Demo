package com.esense.service;

import java.util.List;

public interface CommonService {

	public void save(Object object);
	public void updateObject(Object object);
	public List getListByObject(Class Object);
	public Object getObjectById(Class Object,int id);
	public void removeObjectById(Class Object,int id);
	public List getListByQuery(String query) ;
}
