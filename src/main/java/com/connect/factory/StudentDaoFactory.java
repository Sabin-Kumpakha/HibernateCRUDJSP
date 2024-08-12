package com.connect.factory;

import com.connect.dao.StudentDaoImpl;
import com.connect.dao.iStudentDao;

public class StudentDaoFactory {
	
	private static iStudentDao studentDao;

	private StudentDaoFactory() {
		
	}


	public static iStudentDao getStudentDao() {
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
		
	}
}
