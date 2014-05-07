package com.example.sas;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.LineGraphView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class StartActivity extends Activity {
	private int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		id = extras.getInt("id");
		
		// init example series data
		/*GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
		      new GraphViewData(1, 2.0d)
		      , new GraphViewData(2, 1.5d)
		      , new GraphViewData(3, 2.5d)
		      , new GraphViewData(4, 1.0d)
		});*/
		
		GraphView graphView = new LineGraphView(
			      this // context
			      , "GraphViewDemo" // heading
			);
		
		int[][] signals = RWFile.read(this,"u000001_2014_04_01");
		
		for(int j=0; j < signals.length; j++){
			GraphViewData[] data = new GraphViewData[signals[j].length];
			
			for (int i=0; i<signals[j].length; i++) {
			   data[i] = new GraphViewData(i, signals[j][i]);
			}
			
			//graphView.addSeries(exampleSeries); // data
			graphView.addSeries(new GraphViewSeries(data));
		}
		
		graphView.setViewPort(2, 40);
		graphView.setScrollable(true);
		// optional - activate scaling / zooming
		graphView.setScalable(true);
		graphView.setShowLegend(true); 
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.start_graph);
		layout.addView(graphView);
        
        ((Button) findViewById(R.id.start_button_return)).setOnClickListener(exitListener);
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
