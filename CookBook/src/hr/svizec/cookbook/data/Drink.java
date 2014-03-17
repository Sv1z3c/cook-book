package hr.svizec.cookbook.data;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Drinks")
public class Drink extends Recipe{
	@Column(name = "Country")
	private String country;
	@Column(name = "Name")
	private String name;
	@Column(name = "Ingredients")
	private String[] ingredients;
	@Column(name = "Preparation")
	private String preparation;
	
	public Drink()
	{
		super();
	}
	
	@Override
	public String getCountry() {
		return country;
	}
	@Override
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String[] getIngredients() {
		return ingredients;
	}
	@Override
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	@Override
	public String getPreparation() {
		return preparation;
	}
	@Override
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
}
