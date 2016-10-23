package com.unisyd_elec5619.springmvc.domain;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.persistence.Lob;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.web.multipart.MultipartFile;

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
	private String name;
	public void setName(String name) {
		this.name = name;
	}

	boolean defaultEmoji;
	
	private transient MultipartFile fileLowMood;
	private transient MultipartFile fileMedMood;
	private transient MultipartFile fileHighMood;
	
	@Lob
	private byte[] emojiImageLow;
	@Lob
	private byte[] emojiImageMed;
	@Lob
	private byte[] emojiImageHigh;
	
	
	public MultipartFile getFileHighMood() {
		return fileHighMood;
	}

	public void setFileHighMood(MultipartFile file) {
		this.fileHighMood = file;
		try {
			emojiImageHigh =  file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public MultipartFile getFileMedMood() {
		return fileMedMood;
	}

	public void setFileMedMood(MultipartFile file) {
		this.fileMedMood = file;
		try {
			emojiImageMed =  file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MultipartFile getFileLowMood() {
		return fileLowMood;
	}

	public void setFileLowMood(MultipartFile file) {
		this.fileLowMood = file;
			try {
				emojiImageLow =  file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void setDefaultEmoji(boolean defaultEmoji) {
		this.defaultEmoji = defaultEmoji;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isDefaultEmoji() {
		return defaultEmoji;
	}

	@Override
	public String toString(){
		return "EmojiFamilyName: " + name + " Id: " + id + " Default: " + defaultEmoji + '\n'
				+ "multi part file size: " + fileLowMood.getSize();
	}
	
	@Override
	public Map<EmojiLevelEnum,byte[]> emojiImages(){
		Map<EmojiLevelEnum,byte[]> emojis = new HashMap<EmojiLevelEnum,byte[]>();
		emojis.put(EmojiLevelEnum.LOW, emojiImageLow);
		emojis.put(EmojiLevelEnum.MEDIUM, emojiImageMed);
		emojis.put(EmojiLevelEnum.HIGH, emojiImageHigh);
		return emojis;
	}
	
	
}
