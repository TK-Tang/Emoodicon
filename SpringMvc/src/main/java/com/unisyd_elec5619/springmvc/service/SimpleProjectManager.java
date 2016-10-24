package com.unisyd_elec5619.springmvc.service;

import java.util.List;

import com.unisyd_elec5619.springmvc.domain.Project;

public class SimpleProjectManager implements ProjectManager{

	private List<Project> products;

	@Override
	public void increasePrice(int percentage) {
		//throw new UnsupportedOperationException();
		if(products != null) {
			for (Project product : products) {
				double newPrice = product.getPrice().doubleValue()*
									(100 + percentage)/100;
				product.setPrice(newPrice);
			}
		}	
	}

	@Override
	public List<Project> getProjects() {
		return this.products;
	}
	
	public void setProjects(List<Project> products){
		this.products = products;
		//throw new UnsupportedOperationException();
	}
}
