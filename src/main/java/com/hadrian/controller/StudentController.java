package com.hadrian.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hadrian.dao.DataAccessJDBC;
import com.hadrian.model.Student; // importing our bean class from hadrian.model package

@Controller // which is used to make this class as servlet
public class StudentController {

	// action URL // name attribute
	@RequestMapping(value = "CRUD", params = "register")
	public ModelAndView goToRegisterPage() {

		ModelAndView mv = new ModelAndView(); // creating object for ModelAndView Class

		mv.setViewName("register.jsp");
		// this setViewName redirect us to the "register.jsp" page when we call this
		// method

		return mv;
	}

	// Show page
	@RequestMapping(value = "CRUD", params = "show")
	public ModelAndView goToShowAllPage() {

		ModelAndView mv = new ModelAndView();

		DataAccessJDBC db = new DataAccessJDBC();
		// Directly giving the returned ArrayList from getDetails() method into this new
		// ArrayList
		ArrayList<Student> arr = db.getDetails();

		mv.addObject("listValues", arr); // 1st parameter kind of variable, 2nd is the object value
		// Also called String attributeName(1st parameter), Object attributeValue(2nd
		// parameter)
		// by using this variable name we can use the object value anywhere...
		// Its like Exporting values as objects in JavaScript by using modules.

		mv.setViewName("display.jsp");
		return mv;
	}

	@RequestMapping("edit")
	public ModelAndView editDetails(int id) {

		ModelAndView mv = new ModelAndView();

		DataAccessJDBC db = new DataAccessJDBC();

		Student editableData = db.getDetailsById(id);

		mv.addObject("details", editableData);

		mv.setViewName("Edit.jsp");
		return mv;
	}

	@RequestMapping("delete")
	public ModelAndView deleteTheSelectedRecord(int id) {

		DataAccessJDBC db = new DataAccessJDBC();
		db.delete(id);

		ArrayList<Student> arr = db.getDetails();
		ModelAndView mv = new ModelAndView();
		mv.addObject("listValues", arr);
		mv.setViewName("display.jsp");
		return mv;
	}

	@RequestMapping("update")
	public ModelAndView updateEditedRecords(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("inpSno"));
		String name = request.getParameter("inpName");
		String email = request.getParameter("inpEmail");
		String pass = request.getParameter("inpPass");
		long mobile = Long.parseLong(request.getParameter("inpMobile"));

		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(pass);
		System.out.println(mobile);

		DataAccessJDBC db = new DataAccessJDBC();
		Student s = new Student(id, name, email, pass, mobile);
		db.update(s);

		ArrayList<Student> arr = db.getDetails();

		ModelAndView mv = new ModelAndView();

		mv.addObject("listValues", arr);
		mv.setViewName("display.jsp");
		return mv;
	}

	@RequestMapping("reg")
	public ModelAndView insertRegisteredRecords(HttpServletRequest request) {
		// ModelAndView for redirect. Because after submit we are going to redirect to
		// the "display.jsp" page
		String name = request.getParameter("inpName");
		String email = request.getParameter("inpEmail");
		String pass = request.getParameter("inpPass");
		long mobile = Long.parseLong(request.getParameter("inpMobile"));

		// Our Bean class
		Student s = new Student(name, email, pass, mobile);

		// JDBC connection...
		DataAccessJDBC db = new DataAccessJDBC();
		db.insert(s); // passing the Student class object

		// We're going to redirect display.jsp page
		ModelAndView mv = new ModelAndView();
		ArrayList<Student> arr = db.getDetails();

		mv.addObject("listValues", arr);
		mv.setViewName("display.jsp");
		mv.addObject("progress", "Inserted successfully");
		return mv;
	}
}
