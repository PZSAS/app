package com.example.sas;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class UpdateActivity extends Activity {
	private int id;
	private DBConnector dbc;
	private DBHandler dbh;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		id = extras.getInt("id");
		
		dbc = new DBConnector(this);
		dbh = new DBHandler(this);
		
		((Button) findViewById(R.id.update_button_update)).setOnClickListener(updateListener);
        ((Button) findViewById(R.id.update_button_return)).setOnClickListener(exitListener);
    }
    
    OnClickListener updateListener = new OnClickListener() {
        public void onClick(View v) {
        	dbc.open();
        	dbc.getLogin("antoni");
        	dbc.close();
        	dbh.open();
        	
        	String s = "Baza zosta³a zaktualizowana!\nPobrano dane:\n";
        	Cursor c = dbh.listLogin();
    		if(c.moveToFirst())
    		{
    			s += "Id: " + c.getInt(c.getColumnIndex("user_id")) + "\n";
    			s += "Login: " + c.getString(c.getColumnIndex("login_name")) + "\n";
    			s += "Pass: " + c.getString(c.getColumnIndex("login_password")) + "\n";
    		}
    		c.close();
        	
    		dbh.close();
    		
        	AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
            builder.setMessage(s)
                   .setCancelable(false)
                   .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                       }
                   });
            AlertDialog alert = builder.create();
            alert.show(); 
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
