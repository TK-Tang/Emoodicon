package com.unisyd_elec5619.springmvc;

import java.util.Map;

public interface EmojiFamily {
	public Map<EmojiLevel,EmojiEmotion> emojiFamily();
	public String name();
}
