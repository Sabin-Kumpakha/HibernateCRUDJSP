package com.connect.service;

import com.connect.dao.iStudentDao;
import com.connect.dto.Student;
import com.connect.factory.StudentDaoFactory;

public class StudentServiceImpl implements iStudentService {
	
	iStudentDao studentDao;
	
	@Override
	public String save(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
