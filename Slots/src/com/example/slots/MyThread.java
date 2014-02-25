package com.example.slots;

import android.content.Context;
import android.view.SurfaceHolder;


public class MyThread extends Thread {

	private SurfaceHolder holder;
	private CustomRect customRect;
	private Context context;
	private boolean run = false;

	public MyThread(Context context) {
		
		this.context = context;
	}

	@Override
	public void run() {
		
		customRect = new CustomRect(context, getHolder());
		customRect.draw();
		
	}

	public void setHolder(SurfaceHolder holder){
		this.holder = holder;
		
	}
	
	private SurfaceHolder getHolder(){
		return holder;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
}
