package com.example.right2vote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);    	
	}
	
	public void goToVotingLogistics(View view) {
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), VotingLogisticsActivity.class);
		startActivity(intent);
	}
	
	public void goToRankIssues(View view, String policyArea) {
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), PolicyStatementActivity.class);
		intent.putExtra("policyArea", policyArea);
		startActivity(intent);
	}
	
	public void goToBallot(View view) {
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), ShowBallotActivity.class);
		startActivity(intent);
	}
	
	public void goToSeePolicyAreas(View view) {
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), ShowPolicyAreasActivity.class);
		startActivity(intent);
	}
	
	public void goToShare(View view) {
		this.finishActivity();
		
		Intent intent = new Intent(getApplicationContext(), ShowShareActivity.class);
		startActivity(intent);
	}
	
	public void clearImages(){
		
		/* For the back button */
		
		
		/* From PolicyStatementActivity */
		LinearLayout box = (LinearLayout) findViewById(R.id.box);
		if (box != null) {
			box.removeAllViews(); 
		} 
		
		/* From ShowCandidateActivity & ShowBallotActivity */
		box = (LinearLayout) findViewById(R.id.hilaryBox);
		if (box != null) {
			box.removeAllViews(); 
		}
		
		box = (LinearLayout) findViewById(R.id.cruzBox);
		if (box != null) {
			box.removeAllViews(); 
		}	
		
		/* From VotingLogistiscActivity  */
		RelativeLayout _box = (RelativeLayout) findViewById(R.id.root);
		if (_box != null) {
			_box.removeAllViews(); 
		}						
		
	}
	
	protected void finishActivity(){
		this.clearImages();
		this.finish();
		System.gc();
		overridePendingTransition(0,0);		
	}
}
