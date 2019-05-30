package com.contacts.vanquy.contacts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ListView lv;
    ArrayList<String>arrList=null;
    ArrayAdapter<String> adapter=null;
    private BreakIterator txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[]={"Tran Van Quy","Nguyen Tan Dung","Tran Thanh Nam","Nguyen Dinh Trong"};
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv=(ListView) findViewById(R.id.lvperson);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
//        final TextView txt=(TextView) findViewById(R.id.txtselection);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int arg2,
                                            long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :"+arg2+" ; value ="+arr[arg2]);
                    }
                });
    }
    private void sendData(){
        Intent a = new Intent(this, addd.class);
        startActivity(a);
    }
}






//
//<TextView
//        android:id="@+id/TV0"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="Contacts"
//                android:gravity="top"
//                android:layout_gravity="center_horizontal"
//                android:textSize="22dp"
//                android:textColor="#4348e8"
//                />
//<TextView  android:id="@+id/txtselection"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:background="#dd0230dd"
//        android:hint="Selected person here"
//        />
//<LinearLayout
//        android:orientation="horizontal"
//                android:layout_marginTop="10dp"
//                android:layout_width="match_parent"
//                android:layout_height="200dp">
//<ListView
//            android:id="@+id/listView"
//                    android:layout_width="match_parent"
//                    android:layout_height="fill_parent"
//                    android:background="@color/colorPrimary"
//                    />
//
//</LinearLayout>
//<LinearLayout
//        android:orientation="horizontal"
//                android:layout_width="match_parent"
//                android:gravity="right"
//                android:layout_height="60dp">
//                android:layout_marginTop="15dp"
//<Button
//            android:id="@+id/ok"
//                    android:layout_marginTop="5dp"
//                    android:layout_height="wrap_content"
//                    android:layout_width="70dp"
//                    android:background="#676796"
//                    android:text="+" />
//
//</LinearLayout>

