package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText editText = (EditText) findViewById(R.id.editText);
        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> itemList = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter;

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);

        listView.setAdapter(arrayAdapter);
        
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == keyEvent.ACTION_DOWN)
                    if(keyCode == keyEvent.KEYCODE_ENTER) {
                        String newItem = editText.getText().toString();
                        itemList.add(0, newItem);
                        arrayAdapter.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

    }
}
