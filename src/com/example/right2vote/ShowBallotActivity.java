package com.example.right2vote;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.right2vote.GoHomeActivity;
import com.example.right2vote.PolicyStatementActivity;

public class ShowBallotActivity extends GoHomeActivity {
	private PolicyStatement[] statements; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.statements = PolicyStatementActivity.getStatements();
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_show_ballot);

		if (PolicyStatementActivity.isUserDoneRating()) {
			TextView textView = (TextView) findViewById(R.id.finished);
			textView.setTextSize(15);
			textView.setText("Finished");
		} else {	
			TextView textView = (TextView) findViewById(R.id.notFinished);
			textView.setTextSize(15);
			textView.setText("Not Finished");
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
