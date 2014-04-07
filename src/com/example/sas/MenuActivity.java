package com.example.sas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class MenuActivity extends Activity {
	private static final int REQUEST_CODE = 10;
	private int id;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		id = extras.getInt("id");
		
		((Button) findViewById(R.id.menu_button_start)).setOnClickListener(startListener);
		((Button) findViewById(R.id.menu_button_history)).setOnClickListener(historyListener);
		((Button) findViewById(R.id.menu_button_update)).setOnClickListener(updateListener);
		((Button) findViewById(R.id.menu_button_exit)).setOnClickListener(exitListener);
    }
    
    OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent i = new Intent(MenuActivity.this, StartActivity.class);
    		i.putExtra("id", 1);
    		startActivityForResult(i, REQUEST_CODE);
        }
    };
    
    OnClickListener historyListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent i = new Intent(MenuActivity.this, HistoryActivity.class);
    		i.putExtra("id", 1);
    		startActivityForResult(i, REQUEST_CODE);
        }
    };
    
    OnClickListener updateListener = new OnClickListener() {
        public void onClick(View v) {
        	Intent i = new Intent(MenuActivity.this, UpdateActivity.class);
    		i.putExtra("id", 1);
    		startActivityForResult(i, REQUEST_CODE);
        }
    };
    
    OnClickListener exitListener = new OnClickListener() {
        public void onClick(View v) {
        	finish();
        }
    };
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }

    
}
