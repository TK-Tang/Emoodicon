package com.unisyd_elec5619.springmvc.domain;


import java.awt.image.BufferedImage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

@Entity
@Table(name="Emoji")
public class EmojiLevelImpl implements EmojiEmotion {
	//@JoinColumn(name = "EmojiFamily", referencedColumnName = "Id")
    //@ManyToOne
	
	
	@Id
	@GeneratedValue
	//@Column(name="emoji_family_id")
	int id;
	
	@Column(name="description")
	String levelDescription;
	
	@Lob
	BufferedImage emojiImage;
	
	//@Enumerated(EnumType.STRING)
	EmojiLevelEnum emojiLevelEnum;
	
	public EmojiLevelImpl(String levelDescription, Object emojiImage, EmojiLevelEnum emojiLevelEnum) {
		this.levelDescription = levelDescription;
		//this.emojiImage = (BufferedImage) emojiImage;
		this.emojiLevelEnum = emojiLevelEnum;
	}

	@Override
	public String getLevelDescription() {
		return levelDescription;
	}
	
	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}
	
	@Override
	public BufferedImage getEmojiImage() {
		return emojiImage;
	}
	public void setEmojiImage(BufferedImage emojiImage) {
		this.emojiImage = emojiImage;
	}

	@Override
	public EmojiLevelEnum emojiLevel() {
		// TODO Auto-generated method stub
		return null;
	}
}
