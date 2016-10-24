package com.unisyd_elec5619.springmvc.usertests;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.unisyd_elec5619.springmvc.dao.EmojiFamilyDaoJpaImpl;
import com.unisyd_elec5619.springmvc.service.EmojiCRUDServiceImpl;

@RunWith(PowerMockRunner.class)
public class EmojiFamilyTest {

	@Test
	public void deleteEmojiFamilyTest() {
		EmojiFamilyDaoJpaImpl emojiFamilyDaoImpl = mock(EmojiFamilyDaoJpaImpl.class, RETURNS_DEEP_STUBS);
		EmojiCRUDServiceImpl emojiCRUDServiceImpl = mock(EmojiCRUDServiceImpl.class);
		doCallRealMethod().when(emojiCRUDServiceImpl).setEmojiFamilyDao(emojiFamilyDaoImpl);
		when(emojiFamilyDaoImpl.rowCount()).thenReturn(1L);
		when(emojiFamilyDaoImpl.getEmojiFamilyById(anyLong()).isDefaultEmoji()).thenReturn(false);
		emojiCRUDServiceImpl.setEmojiFamilyDao(emojiFamilyDaoImpl);
		doCallRealMethod().when(emojiCRUDServiceImpl).delete(anyLong());
		// verify not called: emojiDao.delete(id)
		emojiCRUDServiceImpl.delete(5L);
		verify(emojiFamilyDaoImpl, never()).delete(anyLong());
	}

}
