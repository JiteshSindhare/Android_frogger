package com.example.jitesh.newapptrial;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import static com.example.jitesh.newapptrial.Game.getScreenHeight;
import static com.example.jitesh.newapptrial.Game.getScreenWidth;

public class GameView extends View implements View.OnTouchListener , Runnable {

    public static final int DEFAULTCOLOUR = Color.BLACK;
    public static final float DEFAULTPENWIDTH = 3.0f;
    public static final int step_delay=10;
    Paint paint;
    Handler repaintHandler;
    Game game;

    int height=0;
    int width=0;



    public GameView(Context context, AttributeSet attrs){
        super(context, attrs);
        paint=new Paint();
       this.setOnTouchListener(this);

        paint.setColor(DEFAULTCOLOUR);
        paint.setStrokeWidth(DEFAULTPENWIDTH);
        game =new Game();

        repaintHandler=new Handler();
        this.postDelayed(this,step_delay);
    }

/**
    ALL bitmap images are here
 */
    Bitmap frog_i= BitmapFactory.decodeResource(getResources(),R.drawable.frog1);
    Bitmap frog_image=Bitmap.createScaledBitmap(frog_i,80,80,true);

    Bitmap game_o=BitmapFactory.decodeResource(getResources(),R.drawable.game_over1);
    Bitmap game_over_img=Bitmap.createScaledBitmap(game_o,700,700,true);

    Bitmap wod_log=BitmapFactory.decodeResource(getResources(),R.drawable.wood_log1);
    Bitmap wod_log_img=Bitmap.createScaledBitmap(wod_log,250,200,true);

    Bitmap veh=BitmapFactory.decodeResource(getResources(),R.drawable.veh1);
    Bitmap veh_img=Bitmap.createScaledBitmap(veh,150,100,true);

    Bitmap road=BitmapFactory.decodeResource(getResources(),R.drawable.road2);
    Bitmap road_img=Bitmap.createScaledBitmap(road,1080,650,true);

    Bitmap lake=BitmapFactory.decodeResource(getResources(),R.drawable.lake);
    Bitmap lake_img=Bitmap.createScaledBitmap(lake,1080,850,true); // make it 650

    //...................Bitmaps loading ends here.....................
    /**
     * Invoked when screen is touched/Clicked
     */
    @Override
    public boolean onTouch(View view, MotionEvent me) {

      //  Log.d("inside game view"," coming in Touch");
        game.touch(me);
this.step(); // this is here to continue after game over.
        return true;
    }

//    public boolean onTouchEvent(MotionEvent me){
//     //   Log.d("inside game view"," coming in Touch");
//        game.touch(me);
//
//        return true;
//    }
    /**
     * Invoked all draw bitmap method of vehicle , wood plank and frog
     */
    protected void onDraw(Canvas canvas){
        height=canvas.getHeight();
        width=canvas.getWidth();
        int for_road=0;
        int for_lake=0;
        for_road=(int)(height-(height/2.25));
        for_lake=(canvas.getHeight()-((10*height)/11));
      //  Log.d("inside game view"," coming in onDraw");
        super.onDraw(canvas);
        canvas.drawBitmap(road_img,0,(for_road),paint);//canvas.getHeight()-((height)/2)
        canvas.drawBitmap(lake_img,0,for_lake,paint);
        /*
        *   canvas.drawBitmap(road_img,0,canvas.getHeight()-734,paint);
        canvas.drawBitmap(lake_img,0,canvas.getHeight()-1500,paint);
         */
        game.draw(canvas,paint);

        onDrawV(canvas);
        onDrawW(canvas);

        game.draw(canvas,paint,frog_image);
        if(!step()){
            notifyGameOver(canvas,paint,game_over_img);
        }
    }

    /**
     * Invokes method to draw bitmap of Vehicle
     */
    protected void onDrawV(Canvas canvas){
        //Log.d("inside game view"," coming in onDrawVehicle");
        game.drawv(canvas,paint,veh_img);
    }

    /**
     * Invokes method to draw bitmap of Wood plank
     */
    protected void onDrawW(Canvas canvas){
        //Log.d("inside game view"," coming in onDrawplank");
        game.draww(canvas,paint,wod_log_img);
    }

/**
 *  Inovking step method which is responsible for movign vehicles and planks
 *  and also invoking game_over which on being true Invokes---- notifyGameOver()
 */
    public boolean step(){
        game.step();
       if(game.game_over()) {
       //    invalidate();
           return false;
       }else{
        invalidate();
        return true;
       }
    }

//    public void play_frogger(View view) {
//        Log.d("button", "button clocked");
//        Intent play = new Intent(this, game_over.class);
//        startActivity(play);
//    }

/**
 * This method is invokes when game_over is true
 */
    public void notifyGameOver(Canvas can,Paint pai,Bitmap bm){

        can.drawBitmap(game_over_img,getScreenWidth()/2-300,getScreenHeight()/2-400,pai);

    }

    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, GameView.step_delay);
        }
    }
}
