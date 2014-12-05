package com.example.right2vote;

import java.util.HashMap;

public class PolicyStatement {
	
	private String statement;
	private String candidate;
	private String policyArea;
	private boolean doesAgree;
	private boolean seen = false;
	
	public final static String HILARY = "Clinton";
	public final static String CRUZ = "Cruz";
	
	public final static String FOREIGN_POLICY = "Foreign Policy";
	public final static String FISCAL_POLICY= "Fiscal Policy";
	public final static String ENVIRONMENT = "Environmental Policy";
	
	public PolicyStatement(String statement, String candidate, String policyArea) {
		this.statement = statement;
		this.candidate = candidate;
		this.policyArea = policyArea;
	}
	
	public String isFor(){
		if (!this.seen){
			return null;
		}
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
		this.seen = true;
		this.doesAgree = agree;
	}
}
