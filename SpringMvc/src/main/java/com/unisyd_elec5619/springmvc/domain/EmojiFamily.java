package com.unisyd_elec5619.springmvc.domain;

import java.util.Map;
import java.util.Set;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

public interface EmojiFamily {
	//public Map<EmojiLevelEnum,EmojiEmotion> emojiFamily();
	public Set<EmojiEmotion> emojiFamily();
	public String name();
	public boolean isDefault();
	Map<EmojiLevelEnum, EmojiEmotion> emojis();
}
