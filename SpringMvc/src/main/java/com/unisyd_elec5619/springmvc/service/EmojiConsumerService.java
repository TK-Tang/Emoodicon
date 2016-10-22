package com.unisyd_elec5619.springmvc.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

public interface EmojiConsumerService {

	EmojiFamily getEmojiFamily(String emojiFamilyName);

	Set<EmojiFamily> getEmojiFamilies();

	// default emoji family
	EmojiFamily getEmojiFamily();

	List<String> emojiFamilyNames();

	// get all emoji family names
	// 
	
}