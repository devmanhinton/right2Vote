package com.example.right2vote;

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
	private static PolicyStatement[] statements = new PolicyStatement[4];
	private static int currentPolicyNumber = 0;
	private static boolean userRatedAll = false;
	private PolicyStatement currentStatement;
	
	static {
        /* Initialize Policy Statements */
		statements[0] = new PolicyStatement("The United States should focus on reducing defense spending", PolicyStatement.HILARY, "Foreign Policy");
		statements[1] = new PolicyStatement("The United States should not like Unicorns", PolicyStatement.CRUZ, "Environment");
		statements[2] = new PolicyStatement("We need higher taxes to put more money towards education", PolicyStatement.HILARY, "Education");
		statements[3] = new PolicyStatement("Any American should be able to buy any gun he or she wishes", PolicyStatement.CRUZ, "Gun Control");
	}
	
	public static int numberPolicyStatements() {
		return PolicyStatementActivity.statements.length;
	}
	
	public static PolicyStatement[] getStatements(){
		return PolicyStatementActivity.statements;
	}
	
	public static boolean isUserDoneRating() {
		return PolicyStatementActivity.userRatedAll;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_policy_statement);
		
		this.currentStatement = PolicyStatementActivity.statements[this.currentPolicyNumber];
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
    	PolicyStatementActivity.currentPolicyNumber += 1;
    	
    	if (view.getId() == R.id.agree) {
    		this.currentStatement.setAgree(true);
    	} else {
    		this.currentStatement.setAgree(false);
    	}
    	
    	if (this.isFinished()) {
    		this.reset(); 
    		this.calculateWinnerAndShow(view);
    	} else {
    		Intent intent = new Intent(this, PolicyStatementActivity.class);
    		startActivity(intent);
    	}
	}
	
	public void calculateWinnerAndShow(View view){
		Intent intent = new Intent(this, ShowCandidateActivity.class);
		intent.putExtra("winner", this.calculateWinner());
		PolicyStatementActivity.userRatedAll = true;
		startActivity(intent);
	}
	
	public String calculateWinner(){
		int hilary = 0;
		int ted = 0;
		
		for (int i = 0; i<this.statements.length; i++){
			if (this.statements[i].isFor() == PolicyStatement.HILARY) {
				hilary +=1;
			} else {
				ted +=1;
			}
		}
		
		return ted > hilary ? PolicyStatement.CRUZ : PolicyStatement.HILARY; /* Tie goes to Hilary :) */
	}
	
	private boolean isFinished(){
		return PolicyStatementActivity.currentPolicyNumber == PolicyStatementActivity.numberPolicyStatements();
	}
	
	private void reset(){
		PolicyStatementActivity.currentPolicyNumber = 0; 
	}


}
