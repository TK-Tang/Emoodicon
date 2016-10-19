package com.unisyd_elec5619.springmvc.service;

import com.unisyd_elec5619.springmvc.domain.EmojiEmotion;
import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

public interface EmojiCreateUpdateService {
	void addOrUpdateEmojiLevel(EmojiFamily emojiFamily, EmojiEmotion emojiEmotion, EmojiLevelEnum emojiLevel);
	void addOrUpdateEmojiFamily(EmojiFamily emojiFamily);
}

