package com.example.myfragmenttabacvitity;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class _Fragment extends Fragment {

	private View view;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		
		return view= inflater.inflate(R.layout.fragment, container, false);
	}
	
	@Override
	public void onStart() {

		super.onStart();
		initParam();
	}
	
	private void initParam() {
		
		ViewPager viewPager= (ViewPager) view.findViewById(R.id.viewPager);
		
//		PagerTabStrip pagerTabStrip= (PagerTabStrip) view.findViewById(R.id.pagerTabStrip);
//		pagerTabStrip.setTabIndicatorColor(getResources().getColor(android.R.color.black)); 
//        pagerTabStrip.setDrawFullUnderline(false);
//        pagerTabStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
//        pagerTabStrip.setTextSpacing(50);
		List<String> titles= new ArrayList<String>();
		List<Fragment> fragments= new ArrayList<Fragment>();
		titles.add("title1");
		titles.add("title2");
		titles.add("title3");
		titles.add("title4");
		fragments.add(new Fragment1());
		fragments.add(new Fragment2());
		fragments.add(new Fragment2());
		fragments.add(new Fragment3());
		viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), fragments, titles));
	}
	
	class ViewPagerAdapter extends FragmentPagerAdapter {

		List<Fragment> fragments;
		List<String> titles;
		public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
			super(fm);
			this.fragments= fragments;
			this.titles= titles;
		}
		@Override
		public Fragment getItem(int arg0) {

			return fragments.get(arg0);
		}
		@Override
		public int getCount() {

			return fragments.size();
		}
		
		@Override
		public CharSequence getPageTitle(int position) {

			return titles.get(position);
		}
	}
}