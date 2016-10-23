package com.unisyd_elec5619.springmvc.web;


import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
import com.unisyd_elec5619.springmvc.domain.EmojiFamilyImpl;
import com.unisyd_elec5619.springmvc.domain.UserBR;
import com.unisyd_elec5619.springmvc.service.EmojiConsumerService;
import com.unisyd_elec5619.springmvc.service.EmojiCRUDService;
import com.unisyd_elec5619.springmvc.service.UserServiceBR;
import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

@Controller
public class EmojiThemeController {

	@Autowired
	private EmojiConsumerService emojiService;
	
	@Autowired
	private EmojiCRUDService emojiCRUDService;
	

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(value = "/emojiTheme", method = RequestMethod.GET)
    public ModelAndView emojiUserTheme() {
    	EmojiFamilyImpl ef = new EmojiFamilyImpl();
        ModelAndView mv = new ModelAndView("emojiTheme2", "emojiFamilyImpl", ef); // constructor takes model name, view name, model object
        
        ArrayList<EmojiFamily> listThemes = new ArrayList<EmojiFamily>(emojiService.getEmojiFamilies());
        
        Collections.sort(listThemes, new Comparator<EmojiFamily>(){
			@Override
			public int compare(EmojiFamily o1, EmojiFamily o2) {
				return o1.getId() - o2.getId();
			}
        	});
        
        mv.addObject("listThemes", listThemes);
        mv.addObject("ef", ef);
        return mv;
    }

	@RequestMapping(value = "/upload")
	public ModelAndView upload(EmojiFamilyImpl ef){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("emojiTheme2");
		modelAndView.addObject("ef", ef);
		System.out.println("ef.toString(): " + ef.toString());
		emojiCRUDService.addOrUpdateEmojiFamily(ef);
		return modelAndView;
	}
	
	@RequestMapping(value = "/emojiThemeDelete/{id}")
    public ModelAndView deleteTheme(@PathVariable("id") long id) {
		emojiCRUDService.delete(id);
		System.out.println("emojiCRUDService.delete(" + id + ")");
		return new ModelAndView("redirect:/emojiTheme");
	}
	
	@RequestMapping(value = "/emojiThemeUpdate/{id}")
	public ModelAndView updateTheme(@PathVariable("id") long id) {
		System.out.println("/emojiThemeUpdate/{id} called id: " + id);
		EmojiFamilyImpl ef = (EmojiFamilyImpl) emojiService.getEmojiFamilyById(id);
		
		System.out.println(emojiService.getEmojiFamilyById(id).getName());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emojiTheme2");
		mv.addObject("emojiFamilyImpl", ef);
		
		  ArrayList<EmojiFamily> listThemes = new ArrayList<EmojiFamily>(emojiService.getEmojiFamilies());
	        
	        Collections.sort(listThemes, new Comparator<EmojiFamily>(){
				@Override
				public int compare(EmojiFamily o1, EmojiFamily o2) {
					return o1.getId() - o2.getId();
				}
	        	});
	        
	        mv.addObject("listThemes", listThemes);
		return mv;
		
	}
	
    @RequestMapping(value = "/emojiThemeSave")
    public ModelAndView processUser(EmojiFamily ef, BindingResult result) {
        System.out.println("result.hasErrors(): " + result.hasErrors());
        ModelAndView mv = new ModelAndView();
        
        if (result.hasErrors()) {
            mv.setViewName("emojiTheme");
        } else {
            mv.setViewName("emojiTheme");
            emojiCRUDService.addOrUpdateEmojiFamily(ef);
        }

        return mv;
    }

	
}
