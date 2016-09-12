package adi.adiproject2;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by klaus_000 on 9/8/2016.
 */
public class ModDetailsCursorAdapter extends CursorAdapter{

    public ModDetailsCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = (TextView) view.findViewById(R.id.detailsName);
        TextView tvUrl = (TextView) view.findViewById(R.id.detailsUrl);
        TextView tvCategory = (TextView) view.findViewById(R.id.detailsCategory);
        TextView tvEndorsements = (TextView) view.findViewById(R.id.detailsEndorsements);
        TextView tvDescription = (TextView) view.findViewById(R.id.detailsDescription);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
        String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
        String endorsements = cursor.getString(cursor.getColumnIndexOrThrow("endorsements"));
        String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

        tvName.setText(name);
        tvUrl.setText(url);
        tvCategory.setText(category);
        tvEndorsements.setText(endorsements);
        tvDescription.setText(description);

        DatabaseUtils.dumpCursor(cursor);
    }
}
