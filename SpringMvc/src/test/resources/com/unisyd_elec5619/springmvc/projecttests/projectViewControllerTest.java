package com.unisyd_elec5619.springmvc.projecttests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;
import com.unisyd_elec5619.springmvc.service.SimpleProjectManager;
import com.unisyd_elec5619.springmvc.web.ProjectViewController;

import junit.framework.TestCase;

public class projectViewControllerTest extends TestCase{

	public void testHandleRequestView() throws Exception{
		ProjectViewController controller = new ProjectViewController();
		controller.setProjectManager(new SimpleProjectManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("projectList", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map modelMap =(Map) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
		
	}

}
