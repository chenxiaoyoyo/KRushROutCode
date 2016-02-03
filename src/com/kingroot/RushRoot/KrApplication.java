package com.kingroot.RushRoot;

import android.app.Application;
import android.content.Context;

public class KrApplication extends Application {
	private static Context mContext;
	
	public static Context getContext() {
		//a
		return mContext;
	}
	
	public static void setContext(Context context) {
		//a
		mContext = context;
	}
	
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		//undone
	}
	
	public void onTerminate() {
		super.onTerminate();
	}
}
