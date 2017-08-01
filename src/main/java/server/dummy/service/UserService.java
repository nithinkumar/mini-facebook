package server.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.dummy.dao.UserDao;
import server.dummy.domain.User;
import server.dummy.helper.HashHelper;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;

	public void dummy(){
	}
	
	public void addDummyData(){
		
	}
	
	public User getDataById(String id){
		return dao.getUserById(Long.valueOf(id));
	}
	
	public int getUserCountByEmailorPhone(String email, String phone){
		return dao.getUserCountByEmailorPhone(email, phone);
	}
	
	public void addUser(User user){
		user.setPassword(HashHelper.getMd5(user.getPassword()));
		dao.save(user);
	}
}