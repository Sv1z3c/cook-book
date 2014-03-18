package hr.svizec.cookbook.data;

import hr.svizec.cookbook.R;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RecipeAdapter extends ArrayAdapter<Recipe>{
	private Context c;
    private int layoutResourceId;
    private List<Recipe> data = new ArrayList<Recipe>();
    
    public RecipeAdapter(Context context, int layoutResourceId, List<Recipe> data)
    {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.c = context;
        this.data = data;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecipeHolder holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)c).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecipeHolder();
            holder.titleText = (TextView) row.findViewById(R.id.recipeTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (RecipeHolder) row.getTag();
        }

        Recipe recipe = data.get(position);

        holder.titleText.setText(recipe.getName());


        return row;
    }

    static class RecipeHolder
    {
        TextView titleText;
    }

}
