package com.unisyd_elec5619.springmvc.domain;

import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

public interface EmojiFamily {
	//public Map<EmojiLevelEnum,EmojiEmotion> emojiFamily();
	public Set<EmojiEmotion> getEmojiFamily();
	public String getName();
	public boolean isDefaultEmoji();
	Map<EmojiLevelEnum, EmojiEmotion> emojis();
	MultipartFile getFileLowMood();
	void setFileLowMood(MultipartFile file);
}
