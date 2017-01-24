package fuzzle.Fireworksfestival;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by Psyke on 2016-09-27.
 */

public class FileReader extends Activity
{
    InputStream in;
    String read = "";
    StringBuilder sb;
    InputStreamReader stream;
    BufferedReader buffer;

    Context mContext = null;

    public FileReader(Context context, int file)
    {
        this.mContext = context;
        ReadFile(context, file);
    }

    public void ReadFile(Context context, int file) {
        try {
            // getResources().openRawResource()로 raw 폴더의 원본 파일을 가져온다.
            // txt 파일을 InpuStream에 넣는다. (open 한다)
            in = context.getResources().openRawResource(file);

            if (in != null) {

                stream = new InputStreamReader(in, "utf-8");        //utf-8로 인코딩한다.
                buffer = new BufferedReader(stream);
                sb = new StringBuilder("");

                //텍스트 파일을 한줄씩 읽어온다
                read = buffer.readLine();

                //읽어온 텍스트를 출력
                while (read != null) {
                    sb.append(read);
                    sb.append("\n");
                    read = buffer.readLine();
                }

                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}