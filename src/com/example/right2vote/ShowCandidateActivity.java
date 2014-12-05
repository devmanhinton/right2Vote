package com.example.right2vote;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.right2vote.NavigationActivity;
import com.example.right2vote.PolicyStatement;
import com.example.right2vote.PolicyStatementCollection;


public class ShowCandidateActivity extends NavigationActivity {
	private static int HILARY_INDEX = 0;
	private static int CRUZ_INDEX = 1; 
	private static HashMap <String, String[]> candidateDescription = new HashMap<String, String[]>();
	
	static {
		candidateDescription.put(PolicyStatement.ENVIRONMENT, new String[]{"Hilary Env", "Cruz Env"});
		candidateDescription.put(PolicyStatement.FISCAL_POLICY, new String[]{"Hilary fis", "Cruz fis"});
		candidateDescription.put(PolicyStatement.FOREIGN_POLICY, new String[]{"Hilary foreign", "Cruz foreign"});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textBox;
		LinearLayout layout;
		int index;
		
		setContentView(R.layout.activity_show_candidate);
		
		Bundle extras = getIntent().getExtras();
		String winner = extras.getString("winner");
		String policy_area = extras.getString("policy area");
		
		if (winner.equals(PolicyStatement.HILARY)) {
			layout = (LinearLayout) findViewById(R.id.hilaryBox);
			textBox = (TextView) findViewById(R.id.hilaryText);
			index = ShowCandidateActivity.HILARY_INDEX;
		} else {
			layout = (LinearLayout) findViewById(R.id.cruzBox);
			textBox = (TextView) findViewById(R.id.cruzText);
			index = ShowCandidateActivity.CRUZ_INDEX;
		}
		
		textBox.setText(ShowCandidateActivity.candidateDescription.get(policy_area)[index]);
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
