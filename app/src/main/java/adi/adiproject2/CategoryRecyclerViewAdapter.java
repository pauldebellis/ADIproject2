package adi.adiproject2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by klaus_000 on 9/6/2016.
 */
public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private CategoryModel[] mCategories;

    public CategoryRecyclerViewAdapter(List<CategoryModel> mCategories) {
//        this.mCategories = mCategories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout, null);
        CategoryViewHolder viewHolder = new CategoryViewHolder(itemLayoutView, null);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder viewHolder, int position) {
//        CategoryModel currentCategory = mCategories.get(position);
//        viewHolder.categoryName.setText(mCategories[position].getCategory);
    }


    @Override
    public int getItemCount() {
        return 0;
    }


}
