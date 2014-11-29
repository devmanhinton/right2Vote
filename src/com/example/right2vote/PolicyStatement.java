package com.example.right2vote;

import java.util.HashMap;

public class PolicyStatement {
	
	private String statement;
	private String candidate;
	private String policyArea;
	private boolean doesAgree;
	
	public PolicyStatement(String statement, String candidate, String policyArea) {
		this.statement = statement;
		this.candidate = candidate;
		this.policyArea = policyArea;
	}
	
	public String getStatement() {
		return this.statement;
	}
	
	public String getCandidate() {
		return this.candidate;
	}
	
	public boolean userAgrees(){
		return this.doesAgree;
	}
	
	public String getPolicyArea() {
		return this.policyArea;
	}
	
	public void setAgree(boolean agree) {
		this.doesAgree = agree;
	}
	
	public static HashMap whichCandiateWhichArea() {
		HashMap <String, String[]> map = new HashMap();
		
		return map;
		
	}
}
