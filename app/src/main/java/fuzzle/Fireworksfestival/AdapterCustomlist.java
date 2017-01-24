package fuzzle.Fireworksfestival;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Psyke on 2016-08-21.
 */
public class AdapterCustomlist extends BaseAdapter {

    Context mContext;               //나타낼 엑티비티 저장
    ArrayList<CustomlistItem> list_itemArraylist;      //리스트의 값을 저장

    //생성자
    public AdapterCustomlist(Context mContext, ArrayList<CustomlistItem> list_itemArraylist) {
        this.mContext = mContext;
        this.list_itemArraylist = list_itemArraylist;
    }

    //ListView의 아이템 개수를 int형으로 반환
    @Override
    public int getCount() {
        return this.list_itemArraylist.size();
    }

    // 포지션에 해당하는아이템을 객체의 형태로 반환
    @Override
    public Object getItem(int position) {
        return list_itemArraylist.get(position);
    }
    //포지션에 해당하는 아이템의 Id를 반환
    @Override
    public long getItemId(int position) {
        return position;
    }

    //어댑터에 추가된 값을 리스트에 출력
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;


        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_list,null);
            holder = new ViewHolder();

            holder.listTitle = (TextView)convertView.findViewById(R.id.listText);
            holder.listImg = (ImageView)convertView.findViewById(R.id.listImage);
            holder.look_button_bar = (ImageView)convertView.findViewById(R.id.look_button_bar);

            convertView.setTag(holder);
        }else{
            //convertView가 존재한다면 holder를 추가로 생성하지 않고 다시 사용한다.
            holder = (ViewHolder) convertView.getTag();
        }
            holder.listTitle.setText(list_itemArraylist.get(position).getTitle());
            Glide.with(mContext).load(list_itemArraylist.get(position).getImg()).fitCenter().into(holder.listImg);
            Glide.with(mContext).load(R.drawable.customlist_buttombar).fitCenter().into(holder.look_button_bar);
        return convertView;
    }

    public static class ViewHolder{
        public ImageView listImg,look_button_bar;
        public TextView listTitle;
    }
}

