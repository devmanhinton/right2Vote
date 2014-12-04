package com.example.right2vote;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
			String policyArea = policyAreas[i];
			RelativeLayout row = this.clickableRow(policyArea);
			TextView view = this.policyTextView(policyArea);
			ImageView image = this.arrowImage();

			row.addView(view);
			row.addView(image);			
			layout.addView(row);
		}
	}
	
	private RelativeLayout clickableRow(String policyArea){
		RelativeLayout row = new RelativeLayout(getApplicationContext());
		row.setTag(policyArea);
		row.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			ShowPolicyAreasActivity.this.goToRankIssues(v, (String)v.getTag());  
		 }
		});
		
		return row;
	}
	
	private ImageView arrowImage(){
		ImageView image = new ImageView(this);
		image.setImageResource(R.drawable.forward_arrow);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20,30);
		params.setMargins(0, 10, 0, 0);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		image.setLayoutParams(params);
		return image;
	}
	
	private TextView policyTextView(String policyArea){
		TextView view = new TextView(getApplicationContext());
		view.setText(policyArea);
		view.setTextSize(20);
		view.setTextColor(Color.parseColor("#000000"));
		view.setPadding(0, 5, 0, 5);
		return view;
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
