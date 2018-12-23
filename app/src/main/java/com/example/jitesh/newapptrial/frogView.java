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
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class frogView extends View implements Runnable{

    public frogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        timer=new Handler();
        this.postDelayed(this,10);
    }

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

    Handler timer;

    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    float frogPosx=getScreenWidth()/2;
    float frogPosy=getScreenHeight()-250;

    boolean moving;

    //............ vehicles.........
    vehicles v1=new vehicles();
    vehicles v2=new vehicles();
    vehicles v3=new vehicles();
    boolean moveRight1;

    boolean moveRight2;
    boolean moveRight3;
    //.............
//....... experimenting vehicles by arraylist..........
//vehicles v123=new vehicles(40,130,220);



//..................................
    //.........for wood logs......
    wood_logs w1=new wood_logs();
    wood_logs w2=new wood_logs();
    wood_logs w3=new wood_logs();


    boolean moveRight11;
    boolean moveRight22;
    boolean moveRight33;
    //...........
TextView game_end=(TextView)findViewById(R.id.game_over1);
boolean game_over=false;

    protected void onDraw(Canvas canvas){
        Log.d(" screen size in canvas", "width: "+canvas.getWidth()+" height: "+canvas.getHeight());
        //...........for road
        Paint road=new Paint();
        road.setColor(Color.LTGRAY);
        canvas.drawRect(0,getScreenHeight()-750,getScreenWidth(),getScreenHeight()-450,road);

        //.......................


        // .......... for vehicles...........
//
//        for(int i=0;i<v123.dyn_pos_x.size();i++){
//            canvas.drawRect(v123.dyn_pos_left.get(i),v123.dyn_pos_top.get(i)
//            ,v123.dyn_pos_right.get(i),v123.dyn_pos_bottom.get(i),v123.paint_it_dynamically);
//
//        }
        Paint r=new Paint();
        canvas.drawBitmap(road_img,0,canvas.getHeight()-734,r);
        canvas.drawBitmap(veh_img,v1.pos_x,v1.pos_y,v1.paint_it);
        canvas.drawBitmap(veh_img,v2.pos_x,v2.pos_y,v2.paint_it);
        canvas.drawBitmap(veh_img,v3.pos_x,v3.pos_y,v3.paint_it);
        //.............

        //........... for wood logs............

        Paint sea=new Paint();
        sea.setColor(Color.CYAN);
        canvas.drawRect(0,900,getScreenWidth(),200,sea);
        Paint l=new Paint();
        canvas.drawBitmap(lake_img,0,canvas.getHeight()-1500,l);
      //  canvas.drawRect(w1.pos_left,w1.pos_top,w1.pos_right,w1.pos_bottom,w1.paint_it);
      //  canvas.drawRect(w2.pos_left,w2.pos_top,w2.pos_right,w2.pos_bottom,w2.paint_it);
      //  canvas.drawRect(w3.pos_left,w3.pos_top,w3.pos_right,w3.pos_bottom,w3.paint_it);
        canvas.drawBitmap(wod_log_img,w1.pos_x,w1.pos_y,w1.paint_it);
        canvas.drawBitmap(wod_log_img,w2.pos_x,w2.pos_y,w2.paint_it);
        canvas.drawBitmap(wod_log_img,w3.pos_x,w3.pos_y,w3.paint_it);
        //....................

       // game_end=findViewById(R.id.game_over);
        // ............................. collision detection..........

        if(((v1.pos_left<=frogPosx+30 && frogPosx+30<=v1.pos_right)&&
                ( v1.pos_top<=frogPosy+30 && frogPosy+30<=v1.pos_bottom)) ||
                ((v2.pos_left<=frogPosx+30 && frogPosx+30<=v2.pos_right)&&
                        ( v2.pos_top<=frogPosy+30 && frogPosy+30<=v2.pos_bottom)) ||
                ((v3.pos_left<=frogPosx+30 && frogPosx+30<=v3.pos_right)&&
                ( v3.pos_top<=frogPosy+30 && frogPosy+30<=v3.pos_bottom))){
            Log.d("Check Collision"," Collision occured");
            //game_end.setVisibility(View.VISIBLE);
            game_over=true;
         //   Paint g_o=new Paint();
            canvas.drawBitmap(game_over_img,getScreenWidth()/2-300,getScreenHeight()/2-400,sea);
        }else{
            game_over=false;
        }
// && moving

        if((w1.pos_left<=frogPosx+30 && frogPosx+30<=w1.pos_right)&&
                ( w1.pos_top<=frogPosy+30 && frogPosy+30<=w1.pos_bottom)){
          frogPosx=w1.pos_x;
          frogPosy=w1.pos_y;
        }
                if((w2.pos_left<=frogPosx+30 && frogPosx+30<=w2.pos_right)&&
                        ( w2.pos_top<=frogPosy+30 && frogPosy+30<=w2.pos_bottom)){
                    frogPosx=w2.pos_x;
                    frogPosy=w2.pos_y;
        }
                if((w3.pos_left<=frogPosx+30 && frogPosx+30<=w3.pos_right)&&
                        ( w3.pos_top<=frogPosy+30 && frogPosy+30<=w3.pos_bottom)){
                    frogPosx=w3.pos_x;
                    frogPosy=w3.pos_y;
        }


        //................................

        Paint lower_border=new Paint();
        lower_border.setStrokeWidth(10);
        lower_border.setColor(Color.BLACK);
        canvas.drawLine(0,getScreenHeight()-350,getScreenWidth(),getScreenHeight()-350,lower_border);


   //     Log.d(" center of canvas"," center_x"+ getScreenWidth()/2+" center_y"+getScreenHeight()/2);
        Log.d(" Height and width"," Height: "+getScreenHeight()+" Width: "+getScreenWidth());

        // frog

        Paint frog=new Paint();

        canvas.drawBitmap(frog_image,frogPosx,frogPosy,frog);
        frog.setColor(Color.GREEN);

     //   canvas.drawCircle(frogPosx,frogPosy,34,frog);
    }



    public boolean onTouchEvent(MotionEvent me){

        int up_limit=getScreenHeight()/2;
        int down_limit=getScreenHeight();
        int left_limit=getScreenWidth()/2;
        int right_limit=getScreenWidth();

        int center_x=getScreenWidth()/2;
        int center_y=getScreenHeight()/2;


        float touch_x=me.getX();
        float touch_y=me.getY();

 //       Log.d("position of x and y"," pos_X"+touch_x+" pos_y"+touch_y);
// .........working movement..............
//        switch(me.getAction()){
////            case MotionEvent.ACTION_DOWN:
////                frogPosx+=10;
////                invalidate();
////                break;
//
//            case MotionEvent.ACTION_UP:
//                frogPosy-=20;
//                invalidate();
//                break;
//
//                default:
//        }
        //moving=false;
//................. Code to move the frog  " STARTS HERE".................

        if((touch_x-center_x<=150 && touch_x-center_x>=0) && center_y-touch_y>150){
         //   moving=false;
            frogPosy-=35;  // MOVING upwards
        }
        if(touch_x-center_x>150 && (center_y-touch_x<=150 && center_y-touch_x>=0)){
         //   moving=false;
            frogPosx+=35; // MOVING right
        }
        if((touch_x-center_x<=150 && touch_x-center_x>=0) && touch_y-center_y>=150){
        //    moving=false;
            frogPosy+=35; // MOVING down
        }else if((center_x-touch_x>=150) && (center_y-touch_y<=150 && center_y-touch_y>=0)){
         //   moving=false;
            frogPosx-=35;  // MOVING left
        }
        return true;
    }
//.............. code to move the frog " ENDS HERE" ......................

    public void run() {


        if(v1.pos_x>=getScreenWidth()){
            moveRight1=false;
        }

        if(v1.pos_x<=0){
            moveRight1=true;
        }

        if(v2.pos_x>=getScreenWidth()){
            moveRight2=false;
        }

        if(v2.pos_x<=0){
            moveRight2=true;
        }

        if(v3.pos_x>=getScreenWidth()){
            moveRight3=false;
        }

        if(v3.pos_x<=0){
            moveRight3=true;
        }

        if(!game_over) {
            v1.pos_x = v1.move(moveRight1);
            v2.pos_x = v2.move(moveRight2);
            v3.pos_x = v3.move(moveRight3);
        }

        //...................for woodlogs......
        if(w1.pos_x>=getScreenWidth()){
            moveRight11=false;
        }
        if(w1.pos_x<=0){
            moveRight11=true;
        }

        if(w2.pos_x>=getScreenWidth()){
            moveRight22=false;
        }
        if(w2.pos_x<=0){
            moveRight22=true;
        }

        if(w3.pos_x>=getScreenWidth()){
            moveRight33=false;
        }
        if(w3.pos_x<=0){
            moveRight33=true;
        }

        if(!game_over) {
            w1.pos_x = w1.move(moveRight11);
            w2.pos_x = w2.move(moveRight22);
            w3.pos_x = w3.move(moveRight33);
        }
        //..................
        invalidate();
        this.postDelayed(this,10);
    }

}
