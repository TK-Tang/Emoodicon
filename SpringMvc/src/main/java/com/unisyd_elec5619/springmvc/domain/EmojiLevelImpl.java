package com.unisyd_elec5619.springmvc.domain;


import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

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

import org.springframework.util.Base64Utils;

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
	private byte[] emojiImage;
	
	//@Enumerated(EnumType.STRING)
	EmojiLevelEnum emojiLevelEnum;
	
	public EmojiLevelImpl(){}
	
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
	public String base64EncodedImage(){
		// Code adapted from Stack Exchange http://stackoverflow.com/questions/26585804/show-image-on-jsp-with-spring-mvc-and-hibernate
		byte[] encodeBase64 = Base64Utils.encode(emojiImage);
		String base64Encoded = "";
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        // End adapted code
        return base64Encoded;
	}
	
	
	public void setEmojiImage(byte[] emojiImage) {
		this.emojiImage = emojiImage;
	}

	@Override
	public EmojiLevelEnum emojiLevel() {
		return emojiLevelEnum;
	}
	
	@Override
	public String toString(){
		base64EncodedImage();
		return "Id: " + id + "Level: " + this.emojiLevelEnum + " Desc: " + levelDescription + "image length: " + emojiImage.length + " base64EncodedImage()..length(): " + base64EncodedImage().length();
	}
	
}
