package hr.svizec.cookbook.activities;

import java.util.List;

import com.activeandroid.query.Select;

import hr.svizec.cookbook.R;
import hr.svizec.cookbook.data.Appetizer;
import hr.svizec.cookbook.data.Dessert;
import hr.svizec.cookbook.data.Drink;
import hr.svizec.cookbook.data.MainDish;
import hr.svizec.cookbook.data.Recipe;
import hr.svizec.cookbook.data.RecipeAdapter;
import hr.svizec.cookbook.data.Salad;
import hr.svizec.cookbook.data.Soup;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class RecipeList extends Activity {
	
	private String CR = "country";
	private String CAT = "category";
	
	private String selectedCountry;
	private String selectedCategory;
	
	private List<Recipe> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		ListView listView = (ListView) findViewById(R.id.recipeList);
		
		Intent i = getIntent();
		selectedCountry = i.getStringExtra(CR);
		selectedCategory = i.getStringExtra(CAT);
		
		loadData();
		
		RecipeAdapter adapter = new RecipeAdapter(this, R.layout.row_recipe, data);		
		listView.setAdapter(adapter);
	}

	private void loadData() {
		if(selectedCategory.equals("MainDishes"))
			data = new Select().from(MainDish.class)/*.where("Country = ?", selectedCountry)*/.execute();
		else if(selectedCategory.equals("Appetizers"))
			data = new Select().from(Appetizer.class).where("Country = ?", selectedCountry).execute();
		else if(selectedCategory.equals("Desserts"))
			data = new Select().from(Dessert.class).where("Country = ?", selectedCountry).execute();
		else if(selectedCategory.equals("Soups"))
			data = new Select().from(Soup.class).where("Country = ?", selectedCountry).execute();
		else if(selectedCategory.equals("Salads"))
			data = new Select().from(Salad.class).where("Country = ?", selectedCountry).execute();
		else
			data = new Select().from(Drink.class).where("Country = ?", selectedCountry).execute();
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
		getMenuInflater().inflate(R.menu.recipe_list, menu);
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
