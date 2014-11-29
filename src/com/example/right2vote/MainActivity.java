package com.example.right2vote;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import com.example.right2vote.PolicyStatement;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    /** Called when Users Clicks Logistics Image **/
    public void showLogistics(View view) {
    	Intent intent = new Intent(this, VotingLogisticsActivity.class);
    	startActivity(intent);
    	
    }
    public void rankIssues(View view) {
    	Intent intent = new Intent(this, PolicyStatementActivity.class);
    	startActivity(intent);
    }
    public void showBallot(View view) {
    	Intent intent = new Intent(this, ShowBallotActivity.class);
    	startActivity(intent);
    }
}
