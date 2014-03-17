package hr.svizec.cookbook.data;

import com.activeandroid.Model;

public abstract class Recipe extends Model {
	
	public Recipe()
	{
		super();
	}

	public abstract String getCountry();

	public abstract void setCountry(String country);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String[] getIngredients();

	public abstract void setIngredients(String[] ingredients);

	public abstract String getPreparation();

	public abstract void setPreparation(String preparation);
	
}
