package com.unisyd_elec5619.springmvc.users.enums;

import java.util.Map;

import java.util.Set;

public interface EmojiFamily {
	//public Map<EmojiLevelEnum,EmojiEmotion> emojiFamily();
	public Set<EmojiEmotion> emojiFamily();
	public String name();
	public boolean isDefault();
}

