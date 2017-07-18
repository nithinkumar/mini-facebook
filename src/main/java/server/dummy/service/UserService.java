package server.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.dummy.dao.UserDao;
import server.dummy.domain.User;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;

	public void dummy(){
	}
	
	public void addDummyData(){
		
	}
	
	public User getDataById(String id){
		return dao.getUserById(Long.valueOf(id));
	}
}