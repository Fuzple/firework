package fuzzle.Fireworksfestival;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentLook extends Fragment {

    ListView list;
    AdapterCustomlist adapter;
    ArrayList<CustomlistItem> list_ItemArrayList;
    View view;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_look, container, false);
        }

        list = (ListView)view.findViewById(R.id.list);

        list_ItemArrayList = new ArrayList<CustomlistItem>();

        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_gwangalli,"광안리 해수욕장"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_marine_city,"마린시티"));
        list_ItemArrayList.add(new CustomlistItem(R.drawable.place_witerside_park,"만락동 수변공원"));


        adapter = new AdapterCustomlist(getActivity(),list_ItemArrayList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),ActivityLook.class);
                intent.putExtra("placeImg", list_ItemArrayList.get(position).getImg());
                intent.putExtra("topText", list_ItemArrayList.get(position).getTitle());
                intent.putExtra("data",position);
                startActivity(intent);
            }

        });

        return view;
    }
}
