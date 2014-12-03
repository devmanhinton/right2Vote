package com.example.right2vote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NavigationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_go_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.go_home, menu);
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
	
	public void goHome(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);    	
	}
	
	public void goToVotingLogistics(View view) {
		Intent intent = new Intent(this, VotingLogisticsActivity.class);
		startActivity(intent);
	}
	
	public void goToRankIssues(View view, String policyArea) {
		Intent intent = new Intent(this, PolicyStatementActivity.class);
		intent.putExtra("policyArea", policyArea);
		startActivity(intent);
	}
	
	public void goToBallot(View view) {
		Intent intent = new Intent(this, ShowBallotActivity.class);
		startActivity(intent);
	}
	
	public void goToSeePolicyAreas(View view) {
		Intent intent = new Intent(this, ShowPolicyAreasActivity.class);
		startActivity(intent);
	}
	
	public void goToShare(View view) {
		Intent intent = new Intent(this, ShowShareActivity.class);
		startActivity(intent);
	}
}
