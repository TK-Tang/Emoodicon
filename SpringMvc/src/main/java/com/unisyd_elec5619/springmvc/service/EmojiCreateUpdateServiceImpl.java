package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisyd_elec5619.springmvc.dao.EmojiFamilyDao;
import com.unisyd_elec5619.springmvc.domain.EmojiEmotion;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

@Service
public class EmojiCreateUpdateServiceImpl implements EmojiCreateUpdateService {
	
	private EmojiFamilyDao emojiDao;

	@Autowired
	public void setEmojiFamilyDao(EmojiFamilyDao emojiFamilyDao) {
		this.emojiDao = emojiFamilyDao;
	}
	
	@Override
	public void addOrUpdateEmojiFamily(EmojiFamily emojiFamily){
		emojiDao.saveOrUpdate(emojiFamily);
	}

	@Override
	public void addOrUpdateEmojiLevel(EmojiFamily emojiFamily, EmojiEmotion emojiEmotion, EmojiLevelEnum emojiLevel){
		emojiDao.saveOrUpdate(emojiFamily);
	}
}