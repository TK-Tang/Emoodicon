package com.unisyd_elec5619.springmvc.service;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

public interface EmojiCRUDService {
	void addOrUpdateEmojiFamily(EmojiFamily emojiFamily);
	void delete(long id);
}

