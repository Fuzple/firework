package fuzzle.Fireworksfestival;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentLook extends Fragment {

    ListView list;
    AdapterCustomlist adapter;
    ArrayList<CustomlistItem> list_ItemArrayList;
    View view;

    FragmentLocation location = new FragmentLocation();
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState)
    {
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_look, container, false);
        }

        list = (ListView)view.findViewById(R.id.list);

        list_ItemArrayList = new ArrayList<CustomlistItem>();

        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"아르피나"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"시립미술관·벡스코"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"센텀시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"영화의 전당"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"동백섬"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"광안대교"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"황령산"));

        adapter = new AdapterCustomlist(getActivity(),list_ItemArrayList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((ActivitySub)getActivity()).position = String.valueOf(position);   //부모클래스에게 현제 포지션의 값을 전달한다.
                ((ActivitySub)getActivity()).tabLayout.getTabAt(2).select();    //장소안내 페이지로 화면을 전환한다
            }

        });

        return view;
    }
}

