package com.unisyd_elec5619.springmvc.domain;

import java.util.Set;

public interface EmojiFamily {
	//public Map<EmojiLevelEnum,EmojiEmotion> emojiFamily();
	public Set<EmojiEmotion> emojiFamily();
	public String name();
	public boolean isDefault();
}
