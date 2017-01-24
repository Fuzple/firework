package fuzzle.Fireworksfestival;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentLocation extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ArrayList<CustomMaker> mMyMarkersArray = new ArrayList<CustomMaker>();
    private HashMap<Marker, CustomMaker> mMarkersHashMap;
    Marker currentMarker;
    SupportMapFragment mapFragment;
    static View view;
    static View v;
    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
//            if(view == null) {
                view = inflater.inflate(R.layout.fagment_location, container, false);

//            }
        }catch (InflateException e){

// 구글맵 View가 이미 inflate되어 있는 상태이므로, 에러를 무시합니다.
        }
// 이후 메서드 구현 계속
        if(mMap == null) {
            mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.fragment_map);

            //맵 마커와 인포 윈도우등 호출
            mapFragment.getMapAsync(this);
            mMap = null;
        }
        return view;
    }

    @Override
   public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        // 마커와 객체 HashMap를 초기화
        mMarkersHashMap = new HashMap<Marker, CustomMaker>();

        mMyMarkersArray.add(new CustomMaker("광안리 해수욕장",R.drawable.place_gwangalli ,Double.parseDouble("35.152833"),Double.parseDouble("129.118771"),"광안리 해수욕장"));
        mMyMarkersArray.add(new CustomMaker("마린시티",R.drawable.place_marine_city,Double.parseDouble("35.154574"),Double.parseDouble("129.142770"),"영화의전당 주변"));
        mMyMarkersArray.add(new CustomMaker("아르피나",R.drawable.sub_icon_look,Double.parseDouble("35.164797"),Double.parseDouble("129.138338"),"부산 관광공사"));
        mMyMarkersArray.add(new CustomMaker("시립미술관·벡스코",R.drawable.sub_icon_location,Double.parseDouble("35.166760"),Double.parseDouble("129.137024"),"Busan Museum of Art · Bexco"));
        mMyMarkersArray.add(new CustomMaker("센텀시티",R.drawable.sub_icon_fire,Double.parseDouble("35.168588"),Double.parseDouble("129.130678"),"Centum City"));
        mMyMarkersArray.add(new CustomMaker("수변공원",R.drawable.place_witerside_park,Double.parseDouble("35.154514"),Double.parseDouble("129.133176"),"민락동 수변공원"));
        mMyMarkersArray.add(new CustomMaker("영화의 전당",R.drawable.sub_icon_look,Double.parseDouble("35.171173"),Double.parseDouble("129.127199"),"Busan Cinema Center"));
        mMyMarkersArray.add(new CustomMaker("동백섬",R.drawable.sub_icon_look,Double.parseDouble("35.152374"),Double.parseDouble("129.151344"),"동백섬"));
        mMyMarkersArray.add(new CustomMaker("광안대교",R.drawable.sub_icon_fire,Double.parseDouble("35.145826"),Double.parseDouble("129.128496"),"Gwangan Bridge"));
        mMyMarkersArray.add(new CustomMaker("황령산",R.drawable.sub_icon_fire,Double.parseDouble("35.158084"),Double.parseDouble("129.082707"),"Gwangryeongsan"));
//        mMyMarkersArray.add(new CustomMaker("부산문화회관",R.drawable.sub_icon_fire,Double.parseDouble("35.127384"),Double.parseDouble("129.093906"),"부산문화회관"));

        plotMarkers(mMyMarkersArray);

        LatLng sydney = new LatLng(35.145854,129.128577);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14));
    }

    private void plotMarkers(final ArrayList<CustomMaker> markers)
    {
        if(markers.size() > 0) {
            for (final CustomMaker myMarker : markers) {

                //사용자 정의 아이콘 및 기타 옵션을 사용자 마커 만들기
                final MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));

                currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter(this.getContext()));
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Intent intent = new Intent(getActivity(), ActivityMapLocation.class);

                        for(position=0; position < mMyMarkersArray.size(); position++)
                        {
                            if(marker.getPosition().latitude == mMyMarkersArray.get(position).getmLatitude() && marker.getPosition().longitude == mMyMarkersArray.get(position).getmLongitude())
                            {
                                break;
                            }
                        }

                        int i = mMyMarkersArray.get(position).getmIcon();
                        intent.putExtra("map", i);
                        intent.putExtra("placePosition",position);
                        startActivity(intent);
                    }
                });
            }
        }
    }
    //InfoWindowAdapter
    class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        Context mContext;

        public MarkerInfoWindowAdapter(Context context) {
            mContext = context;
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }
        //인포 윈도우 출력부
        @Override
        public View getInfoContents(Marker marker)
        {
            CustomMaker myMarker = mMarkersHashMap.get(marker);

            try{
                v = getActivity().getLayoutInflater().inflate(R.layout.custom_infowindow, null);

                ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);
                TextView markerLabel = (TextView) v.findViewById(R.id.marker_label);
                TextView anotherLabel = (TextView) v.findViewById(R.id.another_label);

                markerIcon.setImageDrawable(new BitmapDrawable(getResources(),BitmapFactory.decodeResource(getResources(),myMarker.getmIcon())));
                markerLabel.setText(myMarker.getmLabel());
                anotherLabel.setText(myMarker.getString());

                v.onFinishTemporaryDetach();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            return v;
        }
    }

    @Override
    public  void onPause(){
        super.onPause();
//        currentMarker.hideInfoWindow();
    }
    // 프래그먼트의 뷰 인스턴스
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(view!=null){
            ViewGroup parent = (ViewGroup)view.getParent();
            if(parent!=null){
                parent.removeView(view);
            }
        }
    }
//    @Override
//    public void onDestroy() {
//        recycleView(view.findViewById(R.id.SubBg));
//    }
//
//    private void recycleView(View view) {
//        if(view != null) {
//            Drawable bg = view.getBackground();
//            if(bg != null) {
//                bg.setCallback(null);
//                ((BitmapDrawable)bg).getBitmap().recycle();
//                view.setBackgroundDrawable(null);
//            }
//        }
//    }
}
