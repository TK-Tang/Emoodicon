package com.unisyd_elec5619.springmvc.web;

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
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProject(HttpServletRequest httpServletRequest) {
		
		Project project = new Project();
		project.setDescription(httpServletRequest.getParameter("description"));
		project.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		this.projectManager.addProject(project);
		
		return "redirect:/projectList.htm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long id, Model uiModel) {
		
		Project project = this.projectManager.getProjectById(id);
		uiModel.addAttribute("project", project);
		
		return "editProject";
	}
	
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editProject(@Valid Project project) {
		
		this.projectManager.updateProject(project);
		System.out.println(project.getId());
		
		return "redirect:/projectList.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteProject(@PathVariable("id") Long id) {
		
		this.projectManager.deleteProject(id);
		
		return "redirect:/projectList.htm";
	}
}
