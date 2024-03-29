package test;

import java.util.ArrayList;
import java.util.Iterator;

import dao.SachDao;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
//		test insert 
//		Sach sach1 = new Sach("JAVA", 50, 2000);
//		Sach sach2 = new Sach("PHP", 50, 2000);
//		Sach sach3 = new Sach("C++", 10, 2001);
//
//		SachDao.getInstance().insert(sach3);
//
//		for (int i = 0; i < 100; i++) {
//			Sach sach = new Sach("Sách " + i, i * 10, 2000 + i);
//			SachDao.getInstance().insert(sach);
//		}

//		test update
//		Sach sach = new Sach(103, "JS", 10000, 2002);
//		SachDao.getInstance().update(sach);
		
//		test delete
//		for (int i = 4; i < 204; i++) {
//			Sach sach = new Sach(i);
//			SachDao.getInstance().delete(sach);
//		}
		
//		test selectAll
//		ArrayList<Sach> list = SachDao.getInstance().selectAll();
//		for (Sach sach : list) {
//			System.out.println(sach.toString());
//		}
		
//		test selectById
//		Sach sach = new Sach(2);
//		Sach s = SachDao.getInstance().selectById(sach);
//		System.out.println(s);
		
//		test condition
		ArrayList<Sach> list = SachDao.getInstance().selectByCondition("giaBan > 10");
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		
	}
}
