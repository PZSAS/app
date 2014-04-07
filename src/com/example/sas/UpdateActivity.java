package com.example.sas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class UpdateActivity extends Activity {
	private int id;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		id = extras.getInt("id");
        
        ((Button) findViewById(R.id.update_button_return)).setOnClickListener(exitListener);
    }
    
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
