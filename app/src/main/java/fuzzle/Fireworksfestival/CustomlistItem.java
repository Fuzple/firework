package fuzzle.Fireworksfestival;

/**
 * Created by 김태홍 on 2016-10-09.
 */

public class  CustomlistItem{
    private int img;
    private String title;

    public CustomlistItem(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}