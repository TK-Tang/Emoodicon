package com.unisyd_elec5619.springmvc.dao;

import java.util.Set;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;

public interface EmojiFamilyDao {
	public Set<EmojiFamily> getAll();
	public void saveOrUpdate(EmojiFamily emojiFamily);
	public EmojiFamily getDefault();
	public Set<EmojiFamily> getNonDefaults();
}
