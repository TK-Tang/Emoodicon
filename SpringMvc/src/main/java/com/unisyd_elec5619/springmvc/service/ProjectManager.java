package com.unisyd_elec5619.springmvc.service;

import java.io.Serializable;
import java.util.List;

import com.unisyd_elec5619.springmvc.domain.Project;


public interface ProjectManager extends Serializable{

    public void increasePrice(int percentage);
    
    public List<Project> getProjects();
    
}