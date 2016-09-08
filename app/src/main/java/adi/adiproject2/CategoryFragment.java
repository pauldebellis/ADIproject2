package adi.adiproject2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment{

    List<String> categories = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }
//      SHOW LIST OF CATEGORIES

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container,
                false);

        categories.add("Models/Textures");
        categories.add("NPCs");
        categories.add("Gameplay");
        categories.add("Magic");

        ListView lv = (ListView)view.findViewById(R.id.categoryList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, categories);
        lv.setAdapter(adapter);
        return view;

//        CLICK ON A CATEGORY TO SEE ALL MODS WITHIN

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String category = lv.getItemAtPosition(i).toString();
//                Intent intent = new Intent(view.getContext(), CategoryDetailFragment.class);
//                intent.putExtra("CATEGORY", category);
//                startActivity(intent);
//
//            }
//        });
    }


}


//

