package test;

import java.util.ArrayList;

import dao.UserDao;
import model.User;

public class TestUser {
	public static void main(String[] args) {
		User u1 = new User("u1", "u123", "uuu");
		ArrayList<User> list = UserDao.getInstance().selectAll();	
		for (User user : list) {
			System.out.println(user);
		}
	}
}
