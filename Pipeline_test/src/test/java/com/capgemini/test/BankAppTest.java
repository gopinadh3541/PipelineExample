package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.ui.BankApplication;

public class BankAppTest {

	@Test
	public void test() {
		BankApplication bank=new BankApplication();
		long l=bank.withdraw("2000");
		assertEquals(98000,l);
	}

}
