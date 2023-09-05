package com.icbt.assignment.consultantservice.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Country_Specialization;
import com.icbt.assignment.consultantservice.services.CommonServices;
import com.icbt.assignment.consultantservice.services.Country_Service;
import com.icbt.assignment.consultantservice.util.EntityValidator;
 
@WebServlet("/CountryControllerServlet")
public class CountryControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/consultationservicedb_application")
	private DataSource dataSource;
    
    public CountryControllerServlet() {
        super();
         
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 String command = null;
	 command = request.getParameter("command");
	    if(command == null )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-LIST") )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-ADDDATA") )
		{
			showAddScreen(request,response);
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String command =request.getParameter("command");
		
		if(command.equals("ADDDATA") )
		{
			addInfo(request,response);
		}
		
		 
	}

	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			  	List<Country_Specialization> country = Country_Service.GetAll(dataSource);
			    request.setAttribute("Country_lists", country);
				request.setAttribute("exceptionerrorshow", "d-none");
				request.getRequestDispatcher("/country_list.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/country_list.jsp").forward(request, response);
			}
		  
		
	}

	private void showAddScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/add_country.jsp").forward(request, response);
		
	}
	
	private void addInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 
		String tableName ="country_specialization";
		String country_name = request.getParameter("country_name");
		
		try {
			
			 if (Country_Service.CheckCountryName(dataSource, country_name, null)) {
				 	String country_specialization_id = CommonServices.GetNumberFormat(dataSource, tableName);
					Country_Specialization country_Specialization = new Country_Specialization(country_specialization_id,country_name);
					
					EntityValidator<Country_Specialization> validator = new EntityValidator<Country_Specialization>();
					String errors = validator.validate(country_Specialization);
					
					if (!errors.isEmpty()) {
						request.setAttribute("Country", country_Specialization);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/add_country.jsp").forward(request, response);
					} else {
						Country_Service.Add(dataSource, country_Specialization);
						CommonServices.SetNumberFormat(dataSource, tableName);
						response.sendRedirect("CountryControllerServlet?command=SHOW-LIST");
					}
			} else {
				request.setAttribute("exceptionerror","Country Name already exists");
				request.setAttribute("exceptionerrorshow", "");
				showAddScreen(request,response);
			}
				
				
			 
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			showAddScreen(request,response);
		}
		
	}

}
