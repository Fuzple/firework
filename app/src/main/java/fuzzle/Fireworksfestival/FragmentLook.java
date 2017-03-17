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

        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli_beach,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_arpina,"아르피나"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_busan_museum_of_art_bexco,"시립미술관·벡스코"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_centum_city,"센텀시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_busan_cinema_center,"영화의 전당"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_dongback_island,"동백섬"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangan_bridge,"광안대교"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"황령산"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_busan_station,"부산역"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_busan_harbor_bridge,"부산항대교"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_un_memorial_cemetery,"UN기념공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_busan_museum,"부산박물관"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_yonghoman,"용호만 유람터미널"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_haeundae_beach,"해운대 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_peace_park,"평화공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangbokro,"광복로"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_songjeong_station,"송정역"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_east_busan_tourism,"동부산광광단지"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_fisheries_science_museum,"수산과학관"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_haedong_yonggungsa,"해동용궁사"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_songjeong_beach,"송정해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_dalmaji_gil_road,"달맞이길"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_oryukdo_islets,"오륙도"));

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

