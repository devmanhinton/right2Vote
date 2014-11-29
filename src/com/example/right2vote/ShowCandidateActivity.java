package com.example.right2vote;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.right2vote.NavigationActivity;
import com.example.right2vote.PolicyStatement;


public class ShowCandidateActivity extends NavigationActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_candidate);
		
		Bundle extras = getIntent().getExtras();
		String winner = extras.getString("winner");
		LinearLayout layout;
		
		if (winner.equals(PolicyStatement.HILARY)) {
			layout = (LinearLayout) findViewById(R.id.hilaryBox);
		} else {
			layout = (LinearLayout) findViewById(R.id.cruzBox);
		}
		
		layout.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_candidate, menu);
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
