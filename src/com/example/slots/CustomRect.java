package com.example.slots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.WindowManager;

public class CustomRect {

	private SurfaceHolder holder;
	private int rect_width = 0;
	private int rect_height = 0;
	private final int RECT_COUNT = 12;
	private final int rect_surface = 3;
	private Context context;

	public CustomRect(Context context, SurfaceHolder holder) {
		this.holder = holder;
		this.context = context;

		init();
	}

	private void init() {
		getWindowsFont();
	}

	private void getWindowsFont() {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);

		int width = wm.getDefaultDisplay().getWidth();
		rect_height = rect_width = width / 6;
		
	}
	Paint paint;
	public void draw() {

		Rect rect = null;
		Canvas canvas = holder.lockCanvas();
		canvas.drawColor(Color.WHITE);
		
		for (int i = 0; i < RECT_COUNT; i++) {
			
			if (i == 0 || i == 1 || i == 2) {
				rect = new Rect(rect_width * (i + 1), rect_height, rect_width * (i + 1) + rect_width, rect_height * 2);
			}else if (i == 3 || i == 4 || i == 5) {
				rect = new Rect(rect_width * (RECT_COUNT / rect_surface), rect_height * (i - 2), rect_width * (RECT_COUNT / rect_surface) + rect_width, rect_height * (i - 2) + rect_height);
			}else if (i == 6 || i == 7 || i == 8) {
				rect = new Rect(rect_width * (RECT_COUNT / RECT_COUNT),  rect_height * (i - 5) + rect_height , rect_width * (RECT_COUNT / RECT_COUNT) + rect_width, rect_height * (i - 5) + rect_height * 2);
			}else if (i == 9 || i == 10 || i == 11) {
				rect = new Rect(rect_width * (i - 7), rect_height * (RECT_COUNT / rect_surface),rect_width * (i - 7) + rect_width, rect_height * (RECT_COUNT / rect_surface) + rect_height);
			}
			drawRect(canvas, rect);
		}

		
		
		holder.unlockCanvasAndPost(canvas);

	}
	
	private void drawRect(Canvas canvas, Rect rect){
		canvas.save();
		paint = new Paint();
		paint.setColor(Color.argb(255, getRadomColor(), getRadomColor(), getRadomColor()));
		canvas.drawRect(rect, paint);
		
		canvas.restore();
	}

	private int getRadomColor() {
		return (int) (Math.random() * 255);
	}

}
