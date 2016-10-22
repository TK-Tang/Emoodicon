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
public class EmojiThemeController {

	@Autowired
	private EmojiConsumerService emojiService;
	
	@Autowired
	private EmojiCreateUpdateService emojiCreateUpdateService;
	

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(value = "/emojiTheme", method = RequestMethod.GET)
    public ModelAndView emojiUserTheme() {
    	EmojiFamily ef = new EmojiFamilyImpl();
        ModelAndView mv = new ModelAndView("emojiTheme", "emojiFamily", ef); // constructor takes model name, view name, model object
        mv.addObject("themeNames", emojiService.emojiFamilyNames());
        mv.addObject("ef", ef);
        return mv;
    }

	@RequestMapping(value = "/emojiThemeRetrieve", method = RequestMethod.GET)
    public ModelAndView emojiUserThemeRetrieve(String themeName) {
    	EmojiFamily ef = emojiService.getEmojiFamily(themeName);
        ModelAndView mv = new ModelAndView("emojiTheme", "emojiFamily", ef); // constructor takes model name, view name, model object
        mv.addObject("themeNames", emojiService.emojiFamilyNames());
        mv.addObject("ef", ef);
        mv.addObject("emojiImg1", ef.emojis().get(EmojiLevelEnum.LOW).base64EncodedImage());
        mv.addObject("emojiImg2", ef.emojis().get(EmojiLevelEnum.MEDIUM).base64EncodedImage());
        mv.addObject("emojiImg3", ef.emojis().get(EmojiLevelEnum.HIGH).base64EncodedImage());
        return mv;
    }
	
	
    @RequestMapping(value = "/emojiThemeSave")
    public ModelAndView processUser(EmojiFamily emojiFamily, BindingResult result) {
        System.out.println("result.hasErrors(): " + result.hasErrors());
        ModelAndView mv = new ModelAndView();
        mv.addObject("ef", emojiFamily);
        mv.addObject("themeNames", emojiService.emojiFamilyNames());
        
        if (result.hasErrors()) {
            mv.setViewName("emojiTheme");
        } else {
            mv.setViewName("emojiTheme");
            emojiCreateUpdateService.addOrUpdateEmojiFamily(emojiFamily);
            
            // temp testing for emoji family
            EmojiFamily ef = new EmojiFamilyImpl("TestEmojiFamily20Oct", false);
            Set<EmojiEmotion> efSet = ef.emojiFamily();
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
