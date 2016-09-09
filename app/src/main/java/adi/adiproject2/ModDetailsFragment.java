package adi.adiproject2;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModDetailsFragment extends Fragment {

    String name;
    String endorsements;
    String category;
    String description;
    String url;


    public ModDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mod_details, container, false);

        TextView modName = (TextView) view.findViewById(R.id.detailName);
        TextView modEndorsements = (TextView) view.findViewById(R.id.detailEndorsements);
        TextView modCategory = (TextView) view.findViewById(R.id.detailCategory);
        TextView modDescription = (TextView) view.findViewById(R.id.detailDescription);
        TextView modUrl = (TextView) view.findViewById(R.id.detailUrl);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.getModDetailed(db);

        ModDetailsCursorAdapter adapter = new ModDetailsCursorAdapter(getActivity(), cursor);

        return view;
    }

}
