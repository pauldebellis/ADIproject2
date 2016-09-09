package adi.adiproject2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by klaus_000 on 9/8/2016.
 */
public class ModListCursorAdapter extends CursorAdapter {

    public ModListCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.mod_list_item, viewGroup, false);
    }


//    Trying to get all details to show in the main list page. Weirdly, only name and endorsements show, and commenting them out
//    doesn't keep them from showing.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = (TextView) view.findViewById(R.id.summaryName);
        TextView tvEndorsements = (TextView) view.findViewById(R.id.summaryEndorsements);
        TextView tvCategory = (TextView) view.findViewById(R.id.summaryCategory);
        TextView tvDescription = (TextView) view.findViewById(R.id.summaryDescription);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String endorsements = cursor.getString(cursor.getColumnIndexOrThrow("endorsements"));
        String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
        String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

        tvName.setText(name);
        tvEndorsements.setText(endorsements);
        tvCategory.setText(category);
        tvDescription.setText(description);
        
    }
}
