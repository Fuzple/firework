package fuzzle.Fireworksfestival;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 김태홍 on 2016-08-23.
 */
public class FragmentTraffic extends Fragment {

    View view;
    ListView traffic_list;
    AdapterCustomlist adapter;
    ArrayList<CustomlistItem> list_ItemArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_traffic, container, false);
        }
        traffic_list = (ListView)view.findViewById(R.id.traffic_list);

        list_ItemArrayList = new ArrayList<CustomlistItem>();

        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"임시 교통정보1"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"임시 교통정보2"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"임시 교통정보3"));

        adapter = new AdapterCustomlist(getActivity(),list_ItemArrayList);

        traffic_list.setAdapter(adapter);

        return view;
    }
    static View v;
    // 프래그먼트의 뷰 인스턴스
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(v!=null){
            ViewGroup parent = (ViewGroup)v.getParent();
            if(parent!=null){
                parent.removeView(v);
            }
        }
    }
}

