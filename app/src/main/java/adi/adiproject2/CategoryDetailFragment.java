package adi.adiproject2;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment {


    public CategoryDetailFragment() {
        // Required empty public constructor
    }

//SHOW A LIST OF ALL MODS IN GIVEN CATEGORY
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        ListView lv = (ListView)view.findViewById(R.id.modList);
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.getModSummary(db);

//"VALUES" VARIABLE SHOULD REPRESENT EACH MOD'S NAME + ENDORSEMENTS
//        String[] values =
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
//        lv.setAdapter(adapter);
        return view;


    }
}
