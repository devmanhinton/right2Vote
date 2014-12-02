package com.example.right2vote;

import java.util.ArrayList;

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
	private ArrayList<PolicyStatement> statements; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LinearLayout layout;
		this.statements = PolicyStatementActivity.getStatements();
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_show_ballot);

		if (PolicyStatementActivity.isUserDoneRating()) {
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
		
		for (int i=0; i < this.statements.size(); i++){
			PolicyStatement statement = statements.get(i);
			String policyArea = statement.getPolicyArea();
			
			TextView view = new TextView(getApplicationContext());
			view.setText(policyArea);
			view.setTextSize(15);
			
			if (statement.isFor() == PolicyStatement.HILARY) {
				hiliaryBox.addView(view);
			} else {
				cruzBox.addView(view);
			}
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
