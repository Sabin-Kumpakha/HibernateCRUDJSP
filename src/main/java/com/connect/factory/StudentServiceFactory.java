package com.connect.factory;

import com.connect.service.StudentServiceImpl;
import com.connect.service.iStudentService;

public class StudentServiceFactory {
	
	private static iStudentService studentServiceImpl;
	
	private StudentServiceFactory() {

	}
	
	public static iStudentService getStudentService() {
		
		if (studentServiceImpl == null)
			studentServiceImpl = new StudentServiceImpl();
		
		return studentServiceImpl;
	}
}
