package employeemanagement.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employeemanagement.dao.EmployeeDAO;
import employeemanagement.dto.Employee;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO ed;
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		ModelAndView view= new ModelAndView();

		try {
			ed.saveEmployee(employee);
			view.setViewName("login.jsp");
		} catch (Exception e) {
			view.addObject("register", "Email id already exist");
			view.setViewName("register.jsp");
		}
		return view;
	}
	
	@RequestMapping("/login")
	public ModelAndView employeeLogin(@RequestParam String email,@RequestParam String pwd) {
		ModelAndView view = new ModelAndView();
		try {
			Employee e= ed.fetchByEmail(email);
			List<Employee> a = ed.fetchAll();
			if(e.getPwd().equals(pwd)) {
				view.addObject("home",a);
				view.setViewName("home.jsp");
			}
			else {
				view.addObject("login","Incorrect password");
				view.setViewName("login.jsp");
			}
		} catch (Exception e) {
			view.addObject("login","Invalid email Id");
			view.setViewName("login.jsp");
		}
		return view;
	}
	@RequestMapping("/update")
	public ModelAndView updateEmployee(@RequestParam int id) {
		Employee e=ed.fetchById(id);
		ModelAndView view= new ModelAndView();
		view.addObject("update",e);
		view.setViewName("update.jsp");
		
		return view;
	}
	
	@RequestMapping("/edit")
	public ModelAndView EditEmployee(@ModelAttribute Employee employee){
		ModelAndView view= new ModelAndView();
			ed.updateEmployee(employee);
			List<Employee> em = ed.fetchAll();
			view.addObject("home",em);
			view.setViewName("home.jsp");
		
		return view;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		Employee e = ed.fetchById(id);
		ed.deleteEmployee(e);
		ModelAndView view = new ModelAndView();
		List<Employee> em = ed.fetchAll();
		view.addObject("home",em);
		view.setViewName("home.jsp");
		
		return view;
	}
	
}
