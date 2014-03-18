package hr.svizec.cookbook.activities;

import hr.svizec.cookbook.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CategorySelect extends Activity
{
	
	private String CR = "country";
	
	private ImageView countryFlag;
	private TextView countryName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_select);
		// Show the Up button in the action bar.
		setupActionBar();
		
		countryFlag = (ImageView) findViewById(R.id.countryFlag);
		countryName = (TextView) findViewById(R.id.countryName);
		
		Intent i = getIntent();
		String selectedCountry = i.getStringExtra(CR);
		
		initWidgets(selectedCountry);
	}

	private void initWidgets(String selectedCountry) {
		
		countryName.setText(selectedCountry);
		
		if(selectedCountry.equals("USA"))
			countryFlag.setImageResource(R.drawable.usaflag);
		else if(selectedCountry.equals("Italy"))
			countryFlag.setImageResource(R.drawable.italianflag);
		else
			countryFlag.setImageResource(R.drawable.indianflag);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
