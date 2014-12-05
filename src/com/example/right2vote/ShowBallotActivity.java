package com.example.right2vote;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.right2vote.NavigationActivity;
import com.example.right2vote.PolicyStatementActivity;

public class ShowBallotActivity extends NavigationActivity {
	private PolicyStatementCollection statements;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LinearLayout layout;
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_show_ballot);
		
		this.statements = PolicyStatementActivity.getStatementsCollection();

		if (PolicyStatementActivity.isUserDoneRatingOne()) {
			layout = (LinearLayout) findViewById(R.id.finished);
			this.setUpFinishedView();
		} else {
			layout = (LinearLayout) findViewById(R.id.notFinished);
		}
		
		layout.setVisibility(View.VISIBLE);
	}
	
	public void setUpFinishedView(){
		LinearLayout hiliaryBox = (LinearLayout) findViewById(R.id.hilaryBox);
		LinearLayout cruzBox = (LinearLayout) findViewById(R.id.cruzBox);
		Map<String, HashSet<String>> policyScoreboard = this.statements.getPolicyWinners();
		HashSet<String> wonByHilary = policyScoreboard.get(PolicyStatement.HILARY);
		HashSet<String> wonByCruz = policyScoreboard.get(PolicyStatement.CRUZ);
		
		this.addPolicyAreasToLayout(hiliaryBox, wonByHilary);
		this.addPolicyAreasToLayout(cruzBox, wonByCruz);
		
	}
	
	private void addPolicyAreasToLayout(LinearLayout layout, HashSet<String> policyAreas){
		Iterator<String> itr = policyAreas.iterator();
		
		while (itr.hasNext()){
			String policyArea = itr.next();
			
			TextView view = new TextView(getApplicationContext());
			view.setText(policyArea);
			view.setTextSize(15);
			
			layout.addView(view);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_ballot, menu);
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
}
