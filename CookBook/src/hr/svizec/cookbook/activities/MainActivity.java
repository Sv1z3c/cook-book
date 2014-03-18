package hr.svizec.cookbook.activities;

import com.activeandroid.query.Select;

import hr.svizec.cookbook.R;
import hr.svizec.cookbook.data.Appetizer;
import hr.svizec.cookbook.data.Dessert;
import hr.svizec.cookbook.data.Drink;
import hr.svizec.cookbook.data.MainDish;
import hr.svizec.cookbook.data.Salad;
import hr.svizec.cookbook.data.Soup;
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
		
		addDefaultRecipes();
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
	
	private void initDatabase() {
		int recipeCount = 0;
		
		recipeCount += new Select().from(MainDish.class).execute().size();
		recipeCount += new Select().from(Appetizer.class).execute().size();
		recipeCount += new Select().from(Dessert.class).execute().size();
		recipeCount += new Select().from(Drink.class).execute().size();
		recipeCount += new Select().from(Salad.class).execute().size();
		recipeCount += new Select().from(Soup.class).execute().size();
		
		if(recipeCount == 0)
		{
			addDefaultRecipes();
		}
	}

	private void addDefaultRecipes() {
		MainDish ddl = new MainDish();
		ddl.setCountry("USA");
		ddl.setName("Deep Dish Lasagna");
		ddl.setIngredients("12 uncooked lasagna noodles;" +
				"1 pound sweet Italian sausage");
		ddl.setPreparation("Preheat oven to 350 degrees F (175 degrees C). Lightly grease a 9x13-inch baking dish." +
							"Bring a large pot of lightly salted water to a boil. Add " +
							"lasagna noodles and cook for 8 to 10 minutes or until al dente; drain.");
		
		ddl.save();
	}

}
