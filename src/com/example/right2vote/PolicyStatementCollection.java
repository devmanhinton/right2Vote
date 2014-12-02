package com.example.right2vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PolicyStatementCollection {
	
	private Map<String, Iterator> IteratorByDomain = new HashMap<String, Iterator>();
	private Map<String, ArrayList<PolicyStatement>> policyStatementByDomain = new HashMap<String, ArrayList<PolicyStatement>>();
	
	public PolicyStatementCollection() {
	}
	
	// Add New Policy Statement
	public boolean addStatement(PolicyStatement statement) {
		ArrayList<PolicyStatement> statements = this.getOrAddStatements(statement.getPolicyArea());
		return statements.add(statement);
	}
	
	// Return by type
	public ArrayList<PolicyStatement> statementsIn(String domain) {
		return this.policyStatementByDomain.get(domain);
	}
	
	// Return # in a given type
	public int numStatementsIn(String domain) {
		ArrayList<PolicyStatement> statements = this.policyStatementByDomain.get(domain);
		if (statements== null) {
				return 0;
		}
		return statements.size();
	}
	
	// Return next statement in type or -1
	public PolicyStatement nextStatementIn(String domain){
		Integer _nextIndex = this.currentIndexByDomain.get(domain);
		if (_nextIndex == null) {
			return null;
		}
		
		int nextIndex = _nextIndex.intValue();
		
		
		this.currentIndexByDomain.put(domain, nextIndex + 1);
	}
	
	private ArrayList<PolicyStatement> getOrAddStatements(String domain) {
		ArrayList<PolicyStatement> statements = this.policyStatementByDomain.get(domain);
		if (statements == null) {
			statements = new ArrayList<PolicyStatement>();
			this.policyStatementByDomain.put(domain, statements);
		}
		return statements;
	}
}
