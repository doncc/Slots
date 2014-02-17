package com.example.slots;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {

	private MyThread myThread = null;
	private Context context;
	private boolean star = false;
	

	public MySurfaceView(Context context) {
		super(context);

		this.context = context;
		init();
	}

	private void init() {

		myThread = new MyThread(context);

		getHolder().addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		myThread.setHolder(holder);
		myThread.setRun(true);
		myThread.start();
	
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		myThread.setRun(false);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			System.out.println("111");
			if (!isStar()) {
				
			}
		}
		return super.onTouchEvent(event);
	}

	public boolean isStar() {
		return star;
	}

	public void setStar(boolean star) {
		this.star = star;
	}
}
