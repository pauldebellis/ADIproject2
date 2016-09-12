package adi.adiproject2;


import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment {

    ListView lv;
    Cursor cursor = null;

    public CategoryDetailFragment() {
        // Required empty public constructor
    }

    public CategoryDetailFragment(Cursor cursor) {
        this.cursor = cursor;
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
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        lv = (ListView) view.findViewById(R.id.modList);

// if cursor is null (which it will be if constructor is run without params, ie at start), show the whole list
        if (cursor == null) {
            //TODO make database helper a singleton
            DatabaseHelper dbHelper = new DatabaseHelper(getContext());
            cursor = dbHelper.getModSummary();
        }
//        DatabaseUtils.dumpCursor(cursor);
        ModListCursorAdapter adapter = new ModListCursorAdapter(getActivity(), cursor);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView modName = (TextView)view.findViewById(R.id.summaryName);
                String name = modName.getText().toString();
                Intent intent = new Intent(getActivity().getBaseContext(), ModDetailsActivity.class);
                intent.putExtra("MODNAME", name);
                getActivity().startActivity(intent);
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

//    public void setCursor (Cursor cursor){
//        DatabaseUtils.dumpCursor(cursor);
//        this.cursor = cursor;
//
////        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
////        ModListCursorAdapter adapter = new ModListCursorAdapter(getActivity(), value);
////
////        lv.setAdapter(adapter);
//
//    }
}
