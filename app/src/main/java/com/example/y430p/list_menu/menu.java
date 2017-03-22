package com.example.y430p.list_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {
    TextView tx=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tx=(TextView) findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.memu,menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem mi)
    {
        if (mi.isChecked())
        {
            mi.setChecked(true);
        }
        switch (mi.getItemId())
        {
            case  R.id.font1:
                tx.setTextSize(10*2);
                break;
            case  R.id.font2:
                tx.setTextSize(12*2);
                break;
            case  R.id.font3:
                tx.setTextSize(14*2);
                break;
            case  R.id.font4:
                Toast.makeText(getApplicationContext(),
                        "普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
            case  R.id.font5:
                tx.setTextColor(Color.RED);
                break;
            case  R.id.font6:
                tx.setTextColor(Color.BLACK);
                break;


        }

        return true;
    }
}
