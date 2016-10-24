package com.unisyd_elec5619.springmvc.dao;

import java.util.List;
import java.util.Set;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

public interface EmojiFamilyDao {
	public Set<EmojiFamily> getAll();
	public void saveOrUpdate(EmojiFamily emojiFamily);
	public EmojiFamily getDefault();
	public Set<EmojiFamily> getNonDefaults();
	public List emojiFamilyNames();
	public void delete(long id);
	public EmojiFamily getEmojiFamilyById(Long id);
	public long rowCount();
	public void clearDefaultEmojiAllRows();
}
