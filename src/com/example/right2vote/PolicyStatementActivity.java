package com.example.right2vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import com.example.right2vote.NavigationActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.right2vote.PolicyStatement;

public class PolicyStatementActivity extends NavigationActivity {
	private static PolicyStatementCollection statementCollection = new PolicyStatementCollection();
	private static PolicyStatement[] statements = new PolicyStatement[4];
	private PolicyStatement currentStatement;
	private String policyArea;
	
	static {
        /* Initialize Policy Statements */
		statementCollection.addStatement(new PolicyStatement("The United States should focus on reducing defense spending", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on helping Israel", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on leaving Iraq", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on discovering terrorists", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
	}
	
	public static ArrayList<PolicyStatement> getStatements(){
		return PolicyStatementActivity.statementCollection.statementsIn(PolicyStatement.FOREIGN_POLICY);
	}
	
	public static boolean isUserDoneRating() {
		return PolicyStatementActivity.statementCollection.isDoneIn(PolicyStatement.FOREIGN_POLICY);
	}
	
	public PolicyStatementCollection collectionOfStatements() {
		return PolicyStatementActivity.statementCollection;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_policy_statement);
		
		this.policyArea = PolicyStatement.FOREIGN_POLICY;
		this.currentStatement = collectionOfStatements().nextStatementIn(this.policyArea);
		this.updateToCurrentStatement();
	}
	
	private void updateToCurrentStatement(){
		TextView textView = (TextView) findViewById(R.id.policyStatement);
		textView.setTextSize(15);
		textView.setText(this.currentStatement.getStatement());		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.policy_statement, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void nextPolicyStatementOrFinish(View view) {
    	
    	if (view.getId() == R.id.agree) {
    		this.currentStatement.setAgree(true);
    	} else {
    		this.currentStatement.setAgree(false);
    	}
    	this.currentStatement = collectionOfStatements().nextStatementIn(this.policyArea);
    	
    	if (this.currentStatement == null) {
    		this.reset(); 
    		this.calculateWinnerAndShow(view);
    	} else {
    		this.updateToCurrentStatement();
    	}
	}
	
	public void calculateWinnerAndShow(View view){
		Intent intent = new Intent(this, ShowCandidateActivity.class);
		intent.putExtra("winner", this.winner());
		this.recordDone();
		startActivity(intent);
	}
	
	public String winner(){
		return this.collectionOfStatements().calculateWinnerIn(this.policyArea);
	}
	
	public void recordDone(){
		this.collectionOfStatements().recordDoneIn(this.policyArea);
		
	}
	
	private void reset(){
		this.collectionOfStatements().resetIterationIn(this.policyArea);
	}


}
