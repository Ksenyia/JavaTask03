package by.tc.task03.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.task03.modal.Person;
import by.tc.task03.dao.Dao;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";
		String contentType = "text/html";
		String requestAttribute = "naming";
		String requestTagName = "command";
		String requestTagValue = "naming";
		String jspFile = "information.jsp";
		
		String name = request.getParameter("name");
		String surname =request.getParameter("surname");
		
		request.setCharacterEncoding(encoding);
		response.setContentType(contentType);
		
		Person person = Dao.getPerson(name,surname);
		Object obj = person;
		
		request.setAttribute(requestAttribute, obj);
		if(requestTagValue.equals(request.getParameter(requestTagName))){
			request.getRequestDispatcher(jspFile).forward(request, response);
		}
	}

}
