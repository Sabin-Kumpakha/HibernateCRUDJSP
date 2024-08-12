package com.connect.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connect.dto.Student;
import com.connect.factory.StudentServiceFactory;
import com.connect.service.iStudentService;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT_ATTRIBUTE = "insert";
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";
	private static final String DELETE_ATTRIBUTE = "delete";
	private static final String NOT_FOUND = "notfound";
	private static final String SEARCH_ATTRIBUTE = "search";
	private static final String SEARCH_NOT_FOUND = "searchnotfound";
	private static final String UPDATE_ATTRIBUTE = "update";
	private static final String UPDATE_SUCCESS = "updateSuccess";
	private static final String UPDATE_FAILURE = "updateFailure";
	private static final String UPDATE_NOT_FOUND = "updateNotFound";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println(("RequestURI : "+requestURI));
		
		iStudentService stdService = StudentServiceFactory.getStudentService();
		
		RequestDispatcher rd = null;
		if (requestURI.endsWith("layout")) {
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
			return;
		}
		
		if (requestURI.endsWith("addform")) {
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");
			
			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddr(saddress);
			
			String status = stdService.save(student);
			System.out.println(status);
			
			  ServletContext context = getServletContext();
		        if (status.equals(SUCCESS)) {
		            context.setAttribute(INSERT_ATTRIBUTE, SUCCESS);
		        } else {
		            context.setAttribute(INSERT_ATTRIBUTE, FAILURE);
		        }

		        rd = request.getRequestDispatcher("../result.jsp");
		        rd.forward(request, response);
		}

		
	    if (requestURI.endsWith("searchform")) {
	        String sid = request.getParameter("sid");
	        Student student = null;
	        if (sid != null && !sid.trim().isEmpty()) {
	            student = stdService.findById(Integer.parseInt(sid));
	        }

	        if (student != null) {
	            request.setAttribute(SEARCH_ATTRIBUTE, student);
	        } else {
	            request.setAttribute(SEARCH_ATTRIBUTE, SEARCH_NOT_FOUND);
	        }

	        rd = request.getRequestDispatcher("../searchResult.jsp");
	        rd.forward(request, response);
	    }
	
		
		
	    if (requestURI.endsWith("deleteform")) {
	        String sid = request.getParameter("sid");
	        String status = stdService.deleteById(Integer.parseInt(sid));

	        if (status.equals(SUCCESS)) {
	            request.setAttribute(DELETE_ATTRIBUTE, SUCCESS);
	        } else if (status.equals(FAILURE)) {
	            request.setAttribute(DELETE_ATTRIBUTE, FAILURE);
	        } else {
	            request.setAttribute(DELETE_ATTRIBUTE, NOT_FOUND);
	        }

	        rd = request.getRequestDispatcher("../deleteResult.jsp");
	        rd.forward(request, response);
	    }
	    
		
		if (requestURI.endsWith("editform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.findById(Integer.parseInt(sid));
			
			if(student != null) {
				response.setContentType("text/html");
				
				//display editpage using html
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>OUTPUT</title></head>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br/><br/><br/>");
				out.println("<form method='post' action='./update' >");
				out.println("<table align='center'>");
				out.println("<tr><th>ID</th><td>"+ student.getSid() +"<td></tr>");
				out.println("<input type='hidden' name='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='"+ student.getSname() +"' /></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='"+ student.getSage() +"' /></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='"+ student.getSaddr() +"' /></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update' /></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				out.close();
				
			} else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
		}
		
		  if (requestURI.endsWith("update")) {
		        String sid = request.getParameter("sid");
		        String sname = request.getParameter("sname");
		        String sage = request.getParameter("sage");
		        String saddr = request.getParameter("saddr");

		        System.out.println(sid);
		        System.out.println(sname);
		        System.out.println(sage);
		        System.out.println(saddr);

		        Student student = new Student();
		        student.setSid(Integer.parseInt(sid));
		        student.setSname(sname);
		        student.setSage(Integer.parseInt(sage));
		        student.setSaddr(saddr);

		        String status = stdService.updateById(student);
		        System.out.println("Status of update: " + status);

		        if (status.equals(SUCCESS)) {
		            request.setAttribute(UPDATE_ATTRIBUTE, UPDATE_SUCCESS);
		        } else if (status.equals(FAILURE)) {
		            request.setAttribute(UPDATE_ATTRIBUTE, UPDATE_FAILURE);
		        } else {
		            request.setAttribute(UPDATE_ATTRIBUTE, UPDATE_NOT_FOUND);
		        }

		        rd = request.getRequestDispatcher("../updateResult.jsp");
		        rd.forward(request, response);
		    }
		//
	}

}
