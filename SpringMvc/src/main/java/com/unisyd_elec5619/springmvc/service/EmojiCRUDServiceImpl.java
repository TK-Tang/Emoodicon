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
		if(emojiFamily.isDefaultEmoji()){emojiDao.clearDefaultEmojiAllRows();};
		emojiDao.saveOrUpdate(emojiFamily);
	}

	@Override
	public void delete(long id) {
		// prevent deletion of default emoji or last record (first condition also prevents last being deleted)
		if(emojiDao.rowCount() > 1 && !emojiDao.getEmojiFamilyById(id).isDefaultEmoji()){
			emojiDao.delete(id);
		}

	}

}