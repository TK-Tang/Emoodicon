package com.unisyd_elec5619.springmvc.service;


import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisyd_elec5619.springmvc.dao.EmojiFamilyDao;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

@Service
public class EmojiConsumerServiceImpl implements EmojiConsumerService {
private EmojiFamilyDao emojiDao;

@Autowired
public void setEmojiFamilyDao(EmojiFamilyDao emojiFamilyDao) {
	this.emojiDao = emojiFamilyDao;
}

@Override
public EmojiFamily getEmojiFamily(String emojiFamilyId){
	// this needs to be updated
	return emojiDao.getDefault();
}

@Override
public Set<EmojiFamily> getEmojiFamilies(){
	return emojiDao.getAll();
}

public Set<String> getAllEmojiFamilyNames(){
	Set<String> allEmojiFamilyNames = new LinkedHashSet<String>();
	for(EmojiFamily ef : emojiDao.getAll()){
		allEmojiFamilyNames.add(ef.name());
	}
	return allEmojiFamilyNames;
}

@Override
public EmojiFamily getEmojiFamily(){
	return emojiDao.getDefault();
}

}

