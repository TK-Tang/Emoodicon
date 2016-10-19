package com.unisyd_elec5619.springmvc.domain;


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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
	
	@OneToMany(targetEntity = EmojiLevelImpl.class,cascade=CascadeType.ALL)
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
		return "EmojiFamilyName: " + name + " Default: " + defaultEmoji;
	}
	
}
