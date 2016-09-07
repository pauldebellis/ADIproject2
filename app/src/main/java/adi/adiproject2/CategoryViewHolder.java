package adi.adiproject2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by klaus_000 on 9/6/2016.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView categoryName;

    public CategoryViewHolder(View itemView, TextView categoryName) {
        super(itemView);
        categoryName = (TextView)itemView.findViewById(R.id.category_name);
    }
//  Set the name of each category
    public void bindDataToViews (CategoryModel categoryData) {
//        categoryName.setText(categoryData.getCategory());

    }

}
