package com.unisyd_elec5619.springmvc.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.unisyd_elec5619.springmvc.users.enums.EmojiLevelEnum;

@Entity
@Table(name="EmojiFamily")
public class EmojiFamilyImpl implements EmojiFamily {
	
	public EmojiFamilyImpl(){}
	
	public EmojiFamilyImpl(String emojiFamilyName, boolean defaultEmoji){
		this.name = emojiFamilyName;
		this.defaultEmoji = defaultEmoji;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	boolean defaultEmoji;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity = EmojiLevelImpl.class,cascade=CascadeType.ALL)
	@JoinColumn(name="family_id")
	Set<EmojiEmotion> emojiFamily = new HashSet<EmojiEmotion>();
	
	@Override
	public Set<EmojiEmotion> emojiFamily() {	
		return emojiFamily;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public boolean isDefault() {
		return defaultEmoji;
	}

	@Override
	public String toString(){
		Object[] emojiLevels = emojiFamily.toArray();
		return "EmojiFamilyName: " + name + " Id: " + id + " Default: " + defaultEmoji + '\n'
				+ ((EmojiEmotion)emojiLevels[0]).toString() + '\n'
				+ ((EmojiEmotion)emojiLevels[1]).toString() + '\n'
				+ ((EmojiEmotion)emojiLevels[2]).toString();
	}
	
	@Override
	public Map<EmojiLevelEnum,EmojiEmotion> emojis(){
		Map<EmojiLevelEnum,EmojiEmotion> emojis = new HashMap<EmojiLevelEnum,EmojiEmotion>();
		for (EmojiEmotion ee : emojiFamily) {
			emojis.put(ee.emojiLevel(), ee);
		}
		return emojis;
	}
}
