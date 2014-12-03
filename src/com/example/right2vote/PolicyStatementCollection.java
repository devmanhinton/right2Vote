package com.example.right2vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.widget.TextView;

public class PolicyStatementCollection {
	
	private Map<String, Iterator<PolicyStatement>> IteratorByDomain = new HashMap<String, Iterator<PolicyStatement>>();
	private Map<String, ArrayList<PolicyStatement>> policyStatementByDomain = new HashMap<String, ArrayList<PolicyStatement>>();
	private Map<String, String> winnerByDomain = new HashMap<String, String>();
	private Map<String, Boolean> doneByDomain = new HashMap<String, Boolean>();
	private Map<String, HashSet<String>> policyWinners = new HashMap<String, HashSet<String>>();
	
	public PolicyStatementCollection() {
		this.policyWinners.put(PolicyStatement.HILARY, new HashSet<String>());
		this.policyWinners.put(PolicyStatement.CRUZ, new HashSet<String>());
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
		if (statements == null) {
				return 0;
		}
		return statements.size();
	}
	
	// Return next statement in type or -1
	public PolicyStatement nextStatementIn(String domain){
		Iterator<PolicyStatement> itr = this.IteratorByDomain.get(domain);
		if (itr == null) {
			ArrayList<PolicyStatement> statements = this.statementsIn(domain);
			if (statements == null){
				return null;
			}
			itr = statements.iterator();
			this.IteratorByDomain.put(domain, itr);
		}
		
		if (itr.hasNext()) {
			return (PolicyStatement) itr.next();
		} else {
			return null;
			
		}
	}
	
	// Reset Iteration
	public void resetIterationIn(String domain) {
		ArrayList<PolicyStatement> statements = this.statementsIn(domain);
		if (statements != null){
			this.IteratorByDomain.put(domain, statements.iterator());
		}
	}
	
	// Calculate Winner
	public String calculateWinnerIn(String domain) {
		int hilary = 0;
		int ted = 0;
		
		ArrayList<PolicyStatement> statements = this.statementsIn(domain);
		
		for (int i = 0; i< statements.size(); i++){
			if (statements.get(i).isFor() == PolicyStatement.HILARY) {
				hilary +=1;
			} else {
				ted +=1;
			}
		}
		String winner = ted > hilary ? PolicyStatement.CRUZ : PolicyStatement.HILARY; 
		
		this.winnerByDomain.put(domain, winner);
		return winner;  		
	}
	
	// Return cached winner, Ugly but for my own use. This is confusing with the calculateWinnerMethod
	// Ideally this would automatically update as the user goes through the statements
	public String winnerIn(String domain){
		return this.winnerByDomain.get(domain);
	}
	
	// Record done
	public void recordDoneIn(String domain){
		this.doneByDomain.put(domain, true);
	}
	
	// Check if done
	public boolean isDoneIn(String domain) {
		Boolean bool = this.doneByDomain.get(domain);
		if (bool == null){
			return false;
		} else {
			return true;
		}
	}
	
	// Return Winners
	public Map<String, HashSet<String>> getPolicyWinners(){
		this.calculateWinners();
		return this.policyWinners;
	}
	
	private void calculateWinners(){
		Iterator<Entry<String, ArrayList<PolicyStatement>>> itr = this.policyStatementByDomain.entrySet().iterator();
		while(itr.hasNext()) {
			Entry<String, ArrayList<PolicyStatement>> etr = itr.next();
			ArrayList<PolicyStatement> statements = etr.getValue();
			String policyWinner = this.winnerFromStatements(statements);
			String policyArea = etr.getKey();
			this.policyWinners.get(policyWinner).add(policyArea);
		}
	}
	
	private String winnerFromStatements(ArrayList<PolicyStatement> statements ){
		int hilary = 0;
		int ted = 0;

		for (int i=0; i < statements.size(); i++){
			PolicyStatement statement = statements.get(i);
			
			if (statement.isFor() == PolicyStatement.HILARY) {
				hilary +=1;
			} else {
				ted += 1;
			}
		}
		
		return ted > hilary ? PolicyStatement.CRUZ : PolicyStatement.HILARY;
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
