package com.unisyd_elec5619.springmvc.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;

@Controller
@RequestMapping(value="/projects/**")
public class ProjectController {
	
	@Resource(name="projectManager")
	private DatabaseProjectManager projectManager;

	@RequestMapping(value="/add")
	public String addProject(Model uiModel) {
		System.out.println("Returning add.jsp");
		uiModel.addAttribute("projects", this.projectManager.getProjects());
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addProject(HttpServletRequest httpServletRequest) {
		System.out.println("Redirecting to projectlist.htm(add)");
		
		Project project = new Project();
		project.setName(httpServletRequest.getParameter("name"));
		project.setDescription(httpServletRequest.getParameter("description"));
		//handle number format exception
		try{
			project.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		}catch(NumberFormatException e){
			project.setPrice(0.0);
		}
		SimpleDateFormat formatterS = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterE = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate;
				
		Date deadline;
		try{
			String dateInString = httpServletRequest.getParameter("projectStartDate");
			System.out.println(dateInString);
			startDate = formatterS.parse(dateInString);
		}catch(ParseException e){
			System.out.println("exception error");
			System.out.println("");
			startDate = new Date();
			startDate.setTime(0);
		}
		try{
			String dateInString = httpServletRequest.getParameter("projectDeadline");
			System.out.println(dateInString);
			deadline = formatterE.parse(dateInString);
		}catch(ParseException e){
			System.out.println("exception error");
			System.out.println("");
			deadline = new Date();
			deadline.setTime(0);
		}
		
		project.setProjectStartDate(startDate);
		project.setProjectDeadline(deadline);
		
		this.projectManager.addProject(project);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long id, Model uiModel) {
		System.out.println("redirecting to editProject");

		Project project = this.projectManager.getProjectById(id);
		// if project start date is null of deadline is null, given default value
		if(project.getProjectStartDate() == null){
            project.setProjectStartDateDefault();
    	}
		if(project.getProjectDeadline() == null){
			project.setProjectDeadlineDefault();
		}
		uiModel.addAttribute("project", project);
		uiModel.addAttribute("projects", this.projectManager.getProjects());
		
		return "editProject";
	}
	
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editProject(@Valid Project project) {		
		System.out.println("redirecting to projectList(edit)");
		this.projectManager.updateProject(project);
		
		return "redirect:/projectList.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteProject(@PathVariable("id") Long id) {
		System.out.println("redirecting to projectList.htm(delete)");

		this.projectManager.deleteProject(id);
		
		return "redirect:/";
	}
}
