package com.example.myfragmenttabacvitity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	
	private String[] titles= {"bar1", "bar2", "bar3", "More"};
	private FragmentTabHost fragmentTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		
	}
	
	private void initUI() {
		
		fragmentTabHost= (FragmentTabHost) findViewById(R.id.fragmentTabHost);
		fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fragment_container);
		for(int i= 0; i< titles.length; i++) {
			
			TabSpec tabSpec= fragmentTabHost.newTabSpec(titles[i])
											.setIndicator(getIndexTailBar(i));
			fragmentTabHost.addTab(tabSpec, _Fragment.class, null);
			fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tag_back);
		}
		fragmentTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				
				
			}
		});
	}
	
	private View getIndexTailBar(int index) {
		
		View view= LayoutInflater.from(this).inflate(R.layout.tail_bar, null);
		TextView text= (TextView) view.findViewById(R.id.tailBarText);
		text.setText(titles[index]);
		return view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
