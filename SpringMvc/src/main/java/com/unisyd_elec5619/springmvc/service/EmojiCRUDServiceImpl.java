package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisyd_elec5619.springmvc.dao.EmojiFamilyDao;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

@Service
public class EmojiCRUDServiceImpl implements EmojiCRUDService {
	
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
	public void delete(long id) {
		emojiDao.delete(id);
	}

}