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
		candidateDescription.put(PolicyStatement.ENVIRONMENT, new String[]{"Clinton supports energy conservation, releasing oil reserves, increasing the number of hydrogen-powered vehicles, and ratification of the Kyoto Protocol. She opposes drilling in the Arctic National Wildlife Refuge, fracking, and the Bush administration's energy policy.", "Ted Cruz supports expanded drilling and opposes cap-and-trade legislation and EPA regulation of greenhouse gases. Ted Cruz supports expanded drilling and opposes cap-and-trade legislation and EPA regulation of greenhouse gases. Cruz challenged the moratorium on offshore drilling in the wake of the BP oilspill. Cruz supports exploring known energy reserves to reduce the country's dependence on foreign oil as an energy source."});
		candidateDescription.put(PolicyStatement.FISCAL_POLICY, new String[]{"Clinton is fiscally liberal and a strong support of using budget surpluses to pay down the national debt as well as support social programs such as Social Security and Medicare. She was highly critical of President Bush;s tax cuts and believes that taxes are important to reduce the deficit. She has not signed the Americans for Tax Reform because she believes that portions of Bush's tax cuts should be repealed. ", "Ted Cruz supports a balanced budget amendment and advocates for markets free of government regulation. He advocates for limiting federal spending growth to per-capita inflation rate."});
		candidateDescription.put(PolicyStatement.FOREIGN_POLICY, new String[]{"Clinton's foreign policy platform is focused primarily on reducing military spending, maintaining tough sanctions on Iran and Russia, settling Arab-Israeli peace, weakening the Assad regime in Syria, and providing non-lethal military assistance", "Ted Cruz is a proponent of the growth of our military forces. Cruz considers himself to be 'somewhere in between those two poles,' of foreign policy extremes. He is pro-Israel."});
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
		
		this.showWinnerTitle(winner, policy_area);
		textBox.setText(ShowCandidateActivity.candidateDescription.get(policy_area)[index]);
		layout.setVisibility(View.VISIBLE);
	}
	
	public void showWinnerTitle(String winner, String policy_area){
		TextView view = (TextView) findViewById(R.id.winner);
		view.setText(winner + "'s " + policy_area);
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
