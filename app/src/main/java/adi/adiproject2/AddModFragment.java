package adi.adiproject2;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddModFragment extends Fragment {

    EditText modName;
    EditText modEndorsements;
    EditText modCategory;
    EditText modDescription;
//    EditText modUrl;

    public AddModFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_mod, container, false);

        modName = (EditText) view.findViewById(R.id.enterModName);
        modEndorsements = (EditText) view.findViewById(R.id.enterModEndorsements);
        modCategory = (EditText) view.findViewById(R.id.enterModCategory);
        modDescription = (EditText) view.findViewById(R.id.enterModDescription);
//        modUrl = (EditText) view.findViewById(R.id.enterModUrl);
        Button addButton = (Button) view.findViewById(R.id.finalizeMod);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMod(view);
                //TODO make the activity swap the fragments. the fragments shouldn't be making assumptions about what views exist inside the activity.
                Fragment modList = new CategoryDetailFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, modList);
                transaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void addMod(View view){
        String name = modName.getText().toString();
        String endorsements = modEndorsements.getText().toString();
//        String url = modUrl.getText().toString();
        String category = modCategory.getText().toString();
        String description = modDescription.getText().toString();
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.addMod(name, endorsements, category, description, db);
        dbHelper.close();
    }

}
