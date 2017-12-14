package fuzzle.Fireworksfestival;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentLocation extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ArrayList<CustomMaker> mMyMarkersArray = new ArrayList<CustomMaker>();
    private HashMap<Marker, CustomMaker> mMarkersHashMap;
    Marker currentMarker;
    MarkerOptions markerOption;
    SupportMapFragment mapFragment;
    static View view;
    static View v;
    int position;
    int data = 0;

    // raw에 저장된 파일들을 순서대로 배열에 저장
    int[] info = {R.raw.location_gwangalli_beach,R.raw.location_marine_city,R.raw.location_arpina,R.raw.location_busan_museum_of_art_bexco,
            R.raw.location_centum_city,R.raw.location_waterfront_park,R.raw.location_busan_cinema_center,R.raw.location_dongbaek_island,
            R.raw.location_gwangan_bridge,R.raw.location_hwangryeong_mt,R.raw.location_busan_station,R.raw.location_busan_harbor_bridge,
            R.raw.location_un_memorial_cemetery,R.raw.location_busan_museum,R.raw.location_yonghoman,R.raw.location_haeundae_beach,
            R.raw.location_peace_park,R.raw.location_gwangbokro,R.raw.location_songjeong_station,R.raw.location_east_busan_tourism,
            R.raw.location_fisheries_science_museum,R.raw.location_haedong_yonggungsa,R.raw.location_songjeong_beach,R.raw.location_dalmaji_gil_road,R.raw.location_oryukdo_island};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
            view = inflater.inflate(R.layout.fagment_location, container, false);
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

        mMyMarkersArray.add(new CustomMaker("광안리 해수욕장",R.drawable.place_gwangalli ,Double.parseDouble("35.152833"),Double.parseDouble("129.118771"),"Gwangalli Beach",0));
        mMyMarkersArray.add(new CustomMaker("마린시티",R.drawable.place_marine_city,Double.parseDouble("35.154574"),Double.parseDouble("129.142770"),"영화의전당 주변",1));
        mMyMarkersArray.add(new CustomMaker("아르피나",R.drawable.place_arpina,Double.parseDouble("35.164797"),Double.parseDouble("129.138338"),"부산 관광공사",2));
        mMyMarkersArray.add(new CustomMaker("시립미술관·벡스코",R.drawable.place_busan_museum_of_art_bexco,Double.parseDouble("35.166760"),Double.parseDouble("129.137024"),"Busan Museum of Art · Bexco",3));
        mMyMarkersArray.add(new CustomMaker("센텀시티",R.drawable.place_centum_city,Double.parseDouble("35.168588"),Double.parseDouble("129.130678"),"Centum City",4));
        mMyMarkersArray.add(new CustomMaker("수변공원",R.drawable.place_witerside_park,Double.parseDouble("35.154514"),Double.parseDouble("129.133176"),"민락동 수변공원",5));
        mMyMarkersArray.add(new CustomMaker("영화의 전당",R.drawable.place_busan_cinema_center,Double.parseDouble("35.171173"),Double.parseDouble("129.127199"),"Busan Cinema Center",6));
        mMyMarkersArray.add(new CustomMaker("동백섬",R.drawable.place_dongback_island,Double.parseDouble("35.152374"),Double.parseDouble("129.151344"),"동백섬",7));
        mMyMarkersArray.add(new CustomMaker("광안대교",R.drawable.place_gwangan_bridge,Double.parseDouble("35.145826"),Double.parseDouble("129.128496"),"Gwangan Bridge",8));
        mMyMarkersArray.add(new CustomMaker("황령산",R.drawable.place_hwangryeong_mt,Double.parseDouble("35.159073"),Double.parseDouble("129.082383"),"Hwangryeongsan",9));
        mMyMarkersArray.add(new CustomMaker("부산역",R.drawable.place_busan_station,Double.parseDouble("35.115025"),Double.parseDouble("129.041449"),"Busan Station",10));
        mMyMarkersArray.add(new CustomMaker("부산항대교",R.drawable.place_busan_harbor_bridge,Double.parseDouble("35.096545"),Double.parseDouble("129.038841"),"Busan Harbor Bridge",11));
        mMyMarkersArray.add(new CustomMaker("UN기념공원",R.drawable.place_un_memorial_cemetery,Double.parseDouble("35.127943"),Double.parseDouble("129.096833"),"UN Memorial Cemetery",12));
        mMyMarkersArray.add(new CustomMaker("부산박물관",R.drawable.place_busan_museum,Double.parseDouble("35.129565"),Double.parseDouble("129.092946"),"Busan museum",13));
        mMyMarkersArray.add(new CustomMaker("용호만 유람터미널",R.drawable.place_yonghoman,Double.parseDouble("35.132319"),Double.parseDouble("129.116219"),"Yonghoman Sightseeing Boat Terminal",14));
        mMyMarkersArray.add(new CustomMaker("해운대 해수욕장",R.drawable.place_haeundae_beach,Double.parseDouble("35.158697"),Double.parseDouble("129.160395"),"Haeundae Beach",15));
        mMyMarkersArray.add(new CustomMaker("평화공원",R.drawable.place_peace_park,Double.parseDouble("35.126922"),Double.parseDouble("129.100891"),"Peace Park",16));
        mMyMarkersArray.add(new CustomMaker("광복로",R.drawable.place_gwangbokro,Double.parseDouble("35.098980"),Double.parseDouble("129.032148"),"Gwangbokro",17));
        mMyMarkersArray.add(new CustomMaker("송정역",R.drawable.place_songjeong_station,Double.parseDouble("35.187811"),Double.parseDouble("129.202373"),"Songjeong Station",18));
        mMyMarkersArray.add(new CustomMaker("동부산관광단지",R.drawable.place_east_busan_tourism,Double.parseDouble("35.191568"),Double.parseDouble("129.215548"),"East Busan Tourism Complex",19));
        mMyMarkersArray.add(new CustomMaker("수산과학관",R.drawable.place_fisheries_science_museum,Double.parseDouble("35.193674"),Double.parseDouble("129.224445"),"Fisheries Science Museum",20));
        mMyMarkersArray.add(new CustomMaker("해동용궁사",R.drawable.place_haedong_yonggungsa,Double.parseDouble("35.188607"),Double.parseDouble("129.223316"),"Haedong Yonggungsa",21));
        mMyMarkersArray.add(new CustomMaker("송정해수욕장",R.drawable.place_songjeong_beach,Double.parseDouble("35.178595"),Double.parseDouble("129.199724"),"Songjeong Beach",22));
        mMyMarkersArray.add(new CustomMaker("달맞이길",R.drawable.place_dalmaji_gil_road,Double.parseDouble("35.157072"),Double.parseDouble("129.181765"),"Dalmaji-gil Road",23));
        mMyMarkersArray.add(new CustomMaker("오륙도",R.drawable.place_oryukdo_islets,Double.parseDouble("35.101511"),Double.parseDouble("129.122997"),"Oryukdo Islets",24));

        plotMarkers(mMyMarkersArray);

        LatLng sydney = new LatLng(35.145854,129.128577);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14));
    }

    private void plotMarkers(final ArrayList<CustomMaker> markers)
    {
        if(markers.size() > -1) {
            for (CustomMaker myMarker : markers) {

                //사용자 정의 아이콘 및 기타 옵션을 사용자 마커 만들기
                markerOption = new MarkerOptions().position(new LatLng(myMarker.getLatitude(), myMarker.getLongitude()));

                currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);
                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter(this.getContext()));

                //정보창 클릭시 다음 화면에 값을 넘겨주고 화면을 전환한다
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Intent intent = new Intent(getActivity(), ActivityMapLocation.class);
                        System.out.println("position = " + position);
                        for(position=0; position < mMyMarkersArray.size(); position++)
                        {
                            if(marker.getPosition().latitude == mMyMarkersArray.get(position).getLatitude() && marker.getPosition().longitude == mMyMarkersArray.get(position).getLongitude())
                            {
                                break;
                            }
                        }
                        String placeName =mMyMarkersArray.get(position).gettitle();
                        int i = mMyMarkersArray.get(position).getIcon();

                        intent.putExtra("placeImg", i);
                        intent.putExtra("placePosition",position);
                        intent.putExtra("placeName",placeName);
                        startActivity(intent);
                    }
                });
            }
        }
    }
    //정보창 어댑터
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
                //커스텀 뷰를 현제화면과 연결하고 리스트에 저장된 값을 출력한다.
                v = getActivity().getLayoutInflater().inflate(R.layout.custom_infowindow, null);

                ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);
                TextView markerLabel = (TextView) v.findViewById(R.id.marker_label);
                TextView anotherLabel = (TextView) v.findViewById(R.id.another_label);
                TextView marker_info = (TextView)v.findViewById(R.id.marker_info);

                FileReader infomation =  new FileReader(getActivity(),info[myMarker.getplaceInfo()]);

                markerIcon.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(),myMarker.getIcon())));
                markerLabel.setText(myMarker.gettitle());
                anotherLabel.setText(myMarker.getprice());
                marker_info.setText(infomation.sb);

                v.onFinishTemporaryDetach();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            return v;
        }
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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        //현제 클래스가 화면에 보여질때.
        if(isVisibleToUser)
        {
            Log.d("실험","성공");
            try {
                if(((ActivitySub) getActivity()).position != null){
                    data = Integer.parseInt(((ActivitySub) getActivity()).position);
                    System.out.println("성공! data = " + data);

                    ArrayList<CustomMaker> markerinfo = new ArrayList<CustomMaker>();
                    markerinfo.add(new CustomMaker(mMyMarkersArray.get(data).gettitle(),mMyMarkersArray.get(data).getIcon(),mMyMarkersArray.get(data).getLatitude(),mMyMarkersArray.get(data).getLongitude(),mMyMarkersArray.get(data).getprice(),mMyMarkersArray.get(data).getplaceInfo()));
                    markerOption = new MarkerOptions().position(new LatLng(mMyMarkersArray.get(data).getLatitude(), mMyMarkersArray.get(data).getLongitude()));

                    plotMarkers(markerinfo);
                    LatLng focus = new LatLng(mMyMarkersArray.get(data).getLatitude(),mMyMarkersArray.get(data).getLongitude());
                    currentMarker.showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(focus,14));
                }
                //현제 화면에서 벗어났을때 인포윈도우를 사라지게 한다.
                else if(((ActivitySub) getActivity()).position == null){
                    currentMarker.hideInfoWindow();
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        //현제 페이지가 화면에서 벗어났을 때
        else
        {
            try
            {
                Log.d("TEST", "LifeCycle invisible(second)");
                //포지션 값을 초기화한다.
                ((ActivitySub) getActivity()).position = null;
                if(((ActivitySub) getActivity()).position == null) {
                    currentMarker.hideInfoWindow();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        super.setUserVisibleHint(isVisibleToUser);
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
