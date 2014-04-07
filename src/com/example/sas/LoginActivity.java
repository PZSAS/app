package com.example.sas;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class LoginActivity extends Activity {
	private static final int REQUEST_CODE = 10;
	private EditText login, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        login = (EditText) findViewById(R.id.login_text_edit_login);
        password = (EditText) findViewById(R.id.login_text_edit_password);
        
        ((Button) findViewById(R.id.login_button)).setOnClickListener(loginListener);
    }
    
    OnClickListener loginListener = new OnClickListener() {
        public void onClick(View v) {
        	String userName = login.getText().toString();
        	String userPass = password.getText().toString();
        	
        	if(userName.compareTo("admin") == 0 && userPass.compareTo("sas") == 0)
        	{
        		Intent i = new Intent(LoginActivity.this, MenuActivity.class);
        		i.putExtra("id", 1);
        		startActivityForResult(i, REQUEST_CODE);
        	}
        	else{
        		AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Wprowadzono niepoprawne dane")
                       .setCancelable(false)
                       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                           }
                       });
                AlertDialog alert = builder.create();
                alert.show(); 
        	}
        }
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }

    
}
