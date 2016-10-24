package com.unisyd_elec5619.springmvc.domain;

import java.util.Map;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

public interface EmojiFamily  {
	public String getName();
	public boolean isDefaultEmoji();
	Map<EmojiLevelEnum, byte[]> emojiImages();
	int getId();
}
