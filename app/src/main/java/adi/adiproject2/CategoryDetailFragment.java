package adi.adiproject2;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment {

    ListView lv;

    public CategoryDetailFragment() {
        // Required empty public constructor
    }

//SHOW A LIST OF ALL MODS
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);

        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment addMod = new AddModFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, addMod);
                transaction.commit();
            }
        });


        lv = (ListView)view.findViewById(R.id.modList);
        //TODO make database helper a singleton
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.getModSummary(db);
//        DatabaseUtils.dumpCursor(cursor);
        ModListCursorAdapter adapter = new ModListCursorAdapter(getActivity(), cursor);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


//
// Not sure how to get search to work with my current setup. Because everything is in fragments, I can't figure
// out how to refresh my listview with only the search results visible. John and I banged our heads against this for about an hour.

    public void displaySearch (Cursor value){
//        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = dbHelper.getModSummary(db);
//        DatabaseUtils.dumpCursor(cursor);

        //TODO make database helper a singleton
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        ModListCursorAdapter adapter = new ModListCursorAdapter(getActivity(), value);

        lv.setAdapter(adapter);

    }
}
