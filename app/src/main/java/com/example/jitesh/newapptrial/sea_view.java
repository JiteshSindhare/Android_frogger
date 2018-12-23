package com.example.jitesh.newapptrial;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class sea_view extends View implements Runnable {


    public sea_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        timer=new Handler();
        this.postDelayed(this,10);

    }

    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    wood_logs w1=new wood_logs();
    wood_logs w2=new wood_logs();
    wood_logs w3=new wood_logs();
    Handler timer;

    boolean moveRight1;
    boolean moveRight2;
    boolean moveRight3;

    @Override
    public void run() {
        if(w1.pos_x>=getScreenWidth()){
            moveRight1=false;
        }
        if(w1.pos_x<=0){
            moveRight1=true;
        }

        if(w2.pos_x>=getScreenWidth()){
            moveRight2=false;
        }
        if(w2.pos_x<=0){
            moveRight2=true;
        }

        if(w3.pos_x>=getScreenWidth()){
            moveRight3=false;
        }
        if(w3.pos_x<=0){
            moveRight3=true;
        }

        w1.pos_x=w1.move(moveRight1);
        w2.pos_x=w2.move(moveRight2);
        w3.pos_x=w3.move(moveRight3);
        invalidate();
        this.postDelayed(this,10);
    }

    protected void onDraw(Canvas canvas){

        Paint sea=new Paint();
        sea.setColor(Color.CYAN);
        canvas.drawRect(0,900,getScreenWidth(),200,sea);
        canvas.drawRect(w1.pos_left,w1.pos_top,w1.pos_right,w1.pos_bottom,w1.paint_it);
        canvas.drawRect(w2.pos_left,w2.pos_top,w2.pos_right,w2.pos_bottom,w2.paint_it);
        canvas.drawRect(w3.pos_left,w3.pos_top,w3.pos_right,w3.pos_bottom,w3.paint_it);

    }
}
