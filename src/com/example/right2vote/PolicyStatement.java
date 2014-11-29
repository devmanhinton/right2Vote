package com.example.right2vote;

import java.util.HashMap;

public class PolicyStatement {
	
	private String statement;
	private String candidate;
	private String policyArea;
	private boolean doesAgree;
	
	public final static String HILARY = "Hilary Clinton";
	public final static String CRUZ = "Ted Cruz";
	
	public PolicyStatement(String statement, String candidate, String policyArea) {
		this.statement = statement;
		this.candidate = candidate;
		this.policyArea = policyArea;
	}
	
	public String isFor(){
		if (this.userAgrees()) {
			return this.candidate;
		} else {
			if (this.candidate == PolicyStatement.HILARY) {
				return PolicyStatement.CRUZ;
			} else {
				return PolicyStatement.HILARY;
			}
		}
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
}
