package com.example.y430p.list_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class list extends AppCompatActivity {
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephent"};
    View v=null;
    private int[] imageIds = new int[]{ R.drawable.lion , R.drawable.tiger
            , R.drawable.monkey, R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);

            listItems.add(listItem);
        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.list,
                new String[] { "personName", "header" },
                new int[] { R.id.name, R.id.header });
        final ListView lists = (ListView) findViewById(R.id.list);
        registerForContextMenu(lists);
        // 为ListView设置Adapter
        lists.setAdapter(simpleAdapter);


        // 为ListView的列表项的单击事件绑定事件监听器
        lists.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (v!=null)
                            v.setBackgroundColor(Color.parseColor("#ffffff"));
                        view.setBackgroundColor(Color.parseColor("#842b00"));
                        v=view;
                        Toast.makeText(getApplicationContext(),
                                names[position], Toast.LENGTH_LONG)
                                .show();


                    }

                });

    }
}
