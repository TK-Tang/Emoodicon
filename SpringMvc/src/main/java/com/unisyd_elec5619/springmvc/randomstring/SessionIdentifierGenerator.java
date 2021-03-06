package com.unisyd_elec5619.springmvc.randomstring;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class SessionIdentifierGenerator {
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}
}