package com.example.right2vote;

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
	private PolicyStatement[] statements; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.statements = PolicyStatementActivity.getStatements();
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_show_ballot);

		if (PolicyStatementActivity.isUserDoneRating()) {
			LinearLayout layout = (LinearLayout) findViewById(R.id.resultBox);
			layout.setVisibility(View.VISIBLE);
		} else {	
			TextView textView = (TextView) findViewById(R.id.notFinished);
			textView.setTextSize(15);
			textView.setVisibility(View.VISIBLE);
			textView.requestLayout();
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
