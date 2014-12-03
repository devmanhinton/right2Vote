package com.example.right2vote;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.right2vote.NavigationActivity;

public class ShowPolicyAreasActivity extends NavigationActivity {
	private static PolicyStatementCollection statementCollection = new PolicyStatementCollection();
	
	static {
        /* Initialize Policy Statements */
		statementCollection.addStatement(new PolicyStatement("The United States should focus on reducing defense spending", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on helping Israel", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on leaving Iraq", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should focus on discovering terrorists", PolicyStatement.HILARY, PolicyStatement.FOREIGN_POLICY));
		statementCollection.addStatement(new PolicyStatement("The United States should spend more money on Education", PolicyStatement.HILARY, PolicyStatement.EDUCATION));
		statementCollection.addStatement(new PolicyStatement("The United States should make college tution free", PolicyStatement.HILARY, PolicyStatement.EDUCATION));
	}
	
	public static PolicyStatementCollection getStatementCollection() {
		return ShowPolicyAreasActivity.statementCollection;
	}
	
	public PolicyStatementCollection statementCollection(){
		return ShowPolicyAreasActivity.statementCollection;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_policy_areas);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.policyBox);
		String[] policyAreas = this.statementCollection().policyAreas();
		
		for (int i=0; i<policyAreas.length; i++){
			TextView view = new TextView(getApplicationContext());
			String policyArea = policyAreas[i];
			
			view.setText(policyArea);
			view.setTextSize(15);
			view.setClickable(true);
			view.setTag(policyArea);
			view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ShowPolicyAreasActivity.this.goToRankIssues(v, (String)v.getTag());  
			 }
			});
			
			layout.addView(view);
		}
	}
	
	public void test(){
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_policy_areas, menu);
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
