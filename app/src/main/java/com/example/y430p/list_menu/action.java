package com.example.y430p.list_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class action extends AppCompatActivity {
    ListView mList;
    private ActionMode actionMode;
    View v=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        mList=(ListView) findViewById(R.id.list2);
        BaseAdapter adapter = new BaseAdapter()
        {
            @Override
            public int getCount()
            {
                // 指定一共包含40个选项
                return 10;
            }
            @Override
            public Object getItem(int position)
            {
                return null;
            }
            // 重写该方法，该方法的返回值将作为列表项的ID
            @Override
            public long getItemId(int position)
            {
                return position;
            }
            // 重写该方法，该方法返回的View将作为列表框
            @Override
            public View getView(int position
                    , View convertView , ViewGroup parent)
            {
                // 创建一个LinearLayout，并向其中添加两个组件
                LinearLayout line = new LinearLayout(action.this);
                line.setOrientation(0);
                ImageView image = new ImageView(action.this);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = new TextView(action.this);
                text.setText("第" + (position +1 ) + "个列表项                            ");

                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                // 返回LinearLayout实例
                return line;
            }
        };
        mList.setAdapter(adapter);

        mList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (actionMode!=null)
                    return false;
                actionMode=startSupportActionMode(macion);
                actionMode.setSubtitle(position+1+"selected");
                view.setBackgroundColor(Color.parseColor("#0000ff"));
                view.setSelected(true);
                v=view;
                return true;
            }
        });

 }
  private ActionMode.Callback macion=new ActionMode.Callback(){



       @Override
      public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
          // TODO Auto-generated method stub
          return false;
      }

       @Override
       public void onDestroyActionMode(ActionMode mode) {
          // TODO Auto-generated method stub
         //当我们不在使用菜单的时候， actionMode = null 在菜单销毁的时候置空
           if (v!=null)
               v.setBackgroundColor(Color.parseColor("#ffffff"));
           actionMode = null;

      }

       //表示我们要加载菜单，从XML中加载菜单
       @Override
       public boolean onCreateActionMode(ActionMode mode, Menu menu) {

          // TODO Auto-generated method stub
         MenuInflater inflate = getMenuInflater();
          inflate.inflate(R.menu.cmenu, menu);

           return true; //返回true 表示加载成功。
       }

       //处理用户的相应动作
      //表示从点击菜单选项中捕获用户的操作
      @Override
       public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
           // TODO Auto-generated method stub
          if (v!=null)
              v.setBackgroundColor(Color.parseColor("#ffffff"));
          return false;
      }

       };

}
