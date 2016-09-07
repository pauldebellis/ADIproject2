package adi.adiproject2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment{

    public CategoryFragment() {
        // Required empty public constructor
    }

//      SHOW LIST OF CATEGORIES

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        super.onCreateView(savedInstanceState);
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_category, container, false);
//
//        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.categoryListFragmentContainer);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container,
                false);

        String[] values = new String[] {"Models/Textures", "Followers", "Gameplay", "Magic"};
        ListView lv = (ListView)view.findViewById(R.id.categoryList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);
        return view;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

// TODO: CLICK ON CATEGORY TO OPEN ITS PAGE
            }
        });
    }


}


//

