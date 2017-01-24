package fuzzle.Fireworksfestival;

import android.app.ActivityGroup;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 김태홍 on 2016-08-23.
 */
public class FragmentFire extends Fragment {
    View view;
    ImageView imageView;
    TextView introduce, introduce_con, place, place_con, reference, reference_con, caution, caution_con;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_fire, container, false);
        }

        imageView = (ImageView)view.findViewById(R.id.festival_info);
        imageView.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.festival)));

        introduce = (TextView)view.findViewById(R.id.introduce);
        introduce_con = (TextView)view.findViewById(R.id.introduce_con);
        place = (TextView)view.findViewById(R.id.place);
        place_con = (TextView)view.findViewById(R.id.place_con);
        reference = (TextView)view.findViewById(R.id.reference);
        reference_con = (TextView)view.findViewById(R.id.reference_con);
        caution = (TextView)view.findViewById(R.id.caution);
        caution_con = (TextView)view.findViewById(R.id.caution_con);

        introduce.setText("1.소개");
        introduce_con.setText("부산광역시에서 주최하며 부산문화관광축제조직위원회에서 주관하는 부산광역시의 관광상품이며, 대한민국 최대 불꽃축제인 동시에 아시아 최대의 불꽃축제 행사이다.\n"
                +"부산국제영화제와 같이 부산에서 가장 유명한 행사이며, 서울세계불꽃축제와 더불어 한국 2대 불꽃축제 중 하나로 손꼽힌다.");
        place.setText("2.개최장소 및 시기");
        place_con.setText("부산 광안리 해수욕장에서 매년 10월 하순경에 개최한다. 날짜는 유동적이지만 메인 불꽃행사는 토요일에 한다. 최대한 관람객을 모으고 다음날 후유증을 최대한 커버할 수 있는 일요일을 두고 하기 때문. 주로 토요일에 개최하는 관습은 서울세계불꽃축제와 비슷하다.\n" +
                "\n" +
                "행사지는 광안리 해수욕장 앞바다와 그뒤 둘러지나가는 광안대교를 배경으로 펼쳐지게 되며, 해수욕장과 인근에 사람들이 몰려오면 바다 위에 배를 띄우고 그 배와 광안대로에서 불꽃을 앞바다로 쏘는 방식으로 진행된다. 바다 위라 화재 염려는 극히 적기 때문에 불꽃은 가히 장관이다.");
        reference.setText("3.촬영시 참조할 점");
        reference_con.setText("");
        caution.setText("4.주의사항");
        caution_con.setText("워낙 많은 관람객이 몰리기 때문에 메인 이벤트 단 하루는 광안리 상권의 최대 성수기다. 바닷가 주변 호텔 식당가는 예약이 몇 달 전부터 이미 완료되어 있을 정도인지라 자연스레 바가지 상술도 기승하게 된다. 이는 숙박이나 먹거리에도 예외가 없다.\n" +
                "\n" +
                "해안가에 쭉 늘어서 있는 카페도 2층 창가석(흡연석 등)을 전부 상품으로 만들어서 판다. 1회때는 단순 자리 예약만 받는 점주들이 대부분이었고 일부 점주들만 촤석에 약간의 돈과 음식을 붙여 팔았는데 이것이 한달전부터 예약이 몰릴 정도로 대박이 나면서 해변가 점주들은 이곳에서 부가수익을 뽑아내기위해 좌석을 판매하기 시작했다. 10월쯤 되면 여름 성수기때의 북적함이 사라져 비수기로 치는데, 이 시즌에 한몫을 해서 손해를 매울수 있다보니 현재는 일부 양심적인 점주들을 제외한 거의 대다수 점주들이 업종불문 좌석판매에 열을 올리고있다.\n" +
                "\n" +
                "축제 몇주 전 부터 예약을 받는데 창가에 있는 테이블을 돈을 주고 앉아야 하는 예약석으로 만들어 버린다. 10~15만원 선. 곳에 따라서는 커피와 조각케익 정도를 주는 곳도 있다.");

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
