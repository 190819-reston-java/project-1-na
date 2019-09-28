package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.Dao;


public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.getWriter().append("Served " + session.getAttribute("user") +
				" at and Closed at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		Dao dao = new Dao();
		try {
			String employees = dao.totalEmployees().toString();
			response.getWriter().write(employees);
			response.setStatus(200);
			
		} catch (SQLException e) {
				response.setStatus(500);
				e.printStackTrace();
			}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Dao dao = new Dao();
		try {
			String employees = dao.totalEmployees().toString();
			response.getWriter().write(employees);
			response.setStatus(200);
			
		} catch (SQLException e) {
				response.setStatus(500);
				e.printStackTrace();
			}
		
		}
				
	}

