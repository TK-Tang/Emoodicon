package com.unisyd_elec5619.springmvc.domain;

import java.awt.image.BufferedImage;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

public interface EmojiEmotion {
	public String getLevelDescription();
	public BufferedImage getEmojiImage();
	public EmojiLevelEnum emojiLevel();
}
