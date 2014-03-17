package hr.svizec.cookbook.activities;

import hr.svizec.cookbook.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private String CR = "country";

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
	
	public void showAboutPage(View v)
	{
		
	}
	
	public void showAmericanRecipes(View v)
	{
		Intent i = new Intent("hr.svizec.cookbook.CategorySelect");
		i.putExtra(CR, "USA");
		startActivity(i);
	}
	
	public void showItalianRecipes(View v)
	{
		Intent i = new Intent("hr.svizec.cookbook.CategorySelect");
		i.putExtra(CR, "Italy");
		startActivity(i);
	}
	
	public void showIndianRecipes(View v)
	{
		Intent i = new Intent("hr.svizec.cookbook.CategorySelect");
		i.putExtra(CR, "India");
		startActivity(i);
	}

}
