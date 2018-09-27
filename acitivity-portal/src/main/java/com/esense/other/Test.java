package com.esense.other;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		new Test().dod(new HashMap());
	}
	
	public void dod(Map m ) {
		System.out.println("Test.dod()");
	}
	public void dod(HashMap m ) {
		System.out.println("Testcxcc.dod()");
	}
	
	
	
}
