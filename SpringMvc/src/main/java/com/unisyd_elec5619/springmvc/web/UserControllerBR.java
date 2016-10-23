package com.unisyd_elec5619.springmvc.web;


import org.hibernate.classic.Session;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unisyd_elec5619.springmvc.domain.EmojiEmotion;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
import com.unisyd_elec5619.springmvc.domain.EmojiFamilyImpl;
import com.unisyd_elec5619.springmvc.domain.EmojiLevelImpl;
import com.unisyd_elec5619.springmvc.domain.UserBR;
import com.unisyd_elec5619.springmvc.service.EmojiConsumerService;
import com.unisyd_elec5619.springmvc.service.EmojiCreateUpdateService;
import com.unisyd_elec5619.springmvc.service.UserServiceBR;
import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

@Controller
public class UserControllerBR {

	@Autowired
	private UserServiceBR userService;
	
	@Autowired
	private EmojiConsumerService emojiService;
	
	@Autowired
	private EmojiCreateUpdateService emojiCreateUpdateService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserControllerBR.class);
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView user() {
    	
        ModelAndView mv = new ModelAndView("userForm", "user", new UserBR()); // constructor takes model name, view name, model object
        mv.addObject("genders", Gender.values());
        mv.addObject("countries", Country.values());
        return mv;
    }

    @RequestMapping(value = "/result")
    //public ModelAndView processUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
    public ModelAndView processUser(UserBR user, BindingResult result) {
        System.out.println("result.hasErrors(): " + result.hasErrors());
        ModelAndView mv = new ModelAndView();
        mv.addObject("u", user);
        mv.addObject("genders", Gender.values());
        mv.addObject("countries", Country.values());

        if (result.hasErrors()) {
            mv.setViewName("userForm");
        } else {
            mv.setViewName("userResult");
            mv.setViewName("emojiTheme");
            
            userService.save(user);
            
            // temp testing for emoji family
            EmojiFamily ef = new EmojiFamilyImpl("TestEmojiFamily20Oct", false);
            Set<EmojiEmotion> efSet = ef.getEmojiFamily();
            efSet.add(new EmojiLevelImpl("testLow19Oct", null, EmojiLevelEnum.LOW));
            efSet.add(new EmojiLevelImpl("testMed19Oct", null, EmojiLevelEnum.MEDIUM));
            efSet.add(new EmojiLevelImpl("testHigh19Oct", null, EmojiLevelEnum.HIGH));
            emojiCreateUpdateService.addOrUpdateEmojiFamily(ef);
            System.out.println(emojiService.getEmojiFamily().toString());
            
            for(String s: emojiService.emojiFamilyNames()){
            	System.out.println("Emoji theme name: " + s);
            }
            
            mv.addObject("emojiImg1", emojiService.getEmojiFamily().emojis().get(EmojiLevelEnum.LOW).base64EncodedImage());
            mv.addObject("emojiImg2", emojiService.getEmojiFamily().emojis().get(EmojiLevelEnum.MEDIUM).base64EncodedImage());
            mv.addObject("emojiImg3", emojiService.getEmojiFamily().emojis().get(EmojiLevelEnum.HIGH).base64EncodedImage());
            mv.addObject("themeNames", emojiService.emojiFamilyNames());
        }

        return mv;
    }

}