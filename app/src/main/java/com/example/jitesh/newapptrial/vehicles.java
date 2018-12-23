package com.example.jitesh.newapptrial;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class vehicles {
    int min_height;
    int max_height;

    float pos_x;
    float pos_y;

    float pos_top;
    float pos_bottom;

    float pos_left;
    float pos_right;

    Paint paint_it;

    public static int step=60;
    //.........variables for dynamically given size

    ArrayList<Integer> dyn_pos_x=new ArrayList<>();
    ArrayList<Integer> dyn_pos_y=new ArrayList<>();

    ArrayList<Integer> dyn_pos_top=new ArrayList<>();
    ArrayList<Integer> dyn_pos_bottom=new ArrayList<>();

    ArrayList<Integer> dyn_pos_left=new ArrayList<>();
    ArrayList<Integer> dyn_pos_right=new ArrayList<>();

    Paint paint_it_dynamically=new Paint();

    public vehicles(int a,int b,int c){
        this.min_height=getScreenHeight()-450;  // 1350
        this.max_height=getScreenHeight()-750;  //1050
        float width=getScreenWidth();
        float height=getScreenHeight();

// 90 should be least distance between two x and y or rect if top/bottom is 30
    //    float multiplier=40;

   //     dyn_pos_x.add(multiplier*n);
   //     dyn_pos_y.add(multiplier*n);
        dyn_pos_x.add((int)width-100);
        dyn_pos_x.add(100);
        dyn_pos_x.add((int)width-100);

        dyn_pos_y.add(min_height-a);
        dyn_pos_y.add(min_height-b);
        dyn_pos_y.add(min_height-c);
//
//        dyn_pos_left.add(dyn_pos_x.get(0)-50);
//        dyn_pos_left.add(dyn_pos_x.get(1)-50);
//        dyn_pos_left.add(dyn_pos_x.get(2)-50);
//
//        dyn_pos_right.add(dyn_pos_x.get(0)+50);
//        dyn_pos_right.add(dyn_pos_x.get(1)+50);
//        dyn_pos_right.add(dyn_pos_x.get(2)+50);
//
//
//        dyn_pos_top.add(dyn_pos_y.get(0)-30);
//        dyn_pos_top.add(dyn_pos_y.get(1)-30);
//        dyn_pos_top.add(dyn_pos_y.get(2)-30);
//
//        dyn_pos_bottom.add(dyn_pos_y.get(0)+30);
//        dyn_pos_bottom.add(dyn_pos_y.get(1)+30);
//        dyn_pos_bottom.add(dyn_pos_y.get(2)+30);

        for(int i=0;i<3;i++){

            dyn_pos_left.add(dyn_pos_x.get(i)-50);
            dyn_pos_right.add(dyn_pos_x.get(i)+50);
            dyn_pos_top.add(dyn_pos_y.get(i)-30);
            dyn_pos_bottom.add(dyn_pos_y.get(i)+30);

        }
        paint_it_dynamically.setColor(Color.GRAY);
    }

    //.......................................

    // .............Default constructor.................
    public vehicles(){

        // determine the range of place where the trucks will move;
         this.min_height=getScreenHeight()-450;
        this.max_height=getScreenHeight()-750;

        Random rand=new Random();

         pos_x= rand.nextInt(getScreenWidth());
         pos_y=rand.nextInt((min_height-max_height)+1)+max_height;

         this.pos_top=this.pos_y-100;
         this.pos_bottom=this.pos_y+100;

         this.pos_left=this.pos_x-75;
         this.pos_right=this.pos_x+75;

         paint_it=new Paint();
         paint_it.setColor(Color.BLACK);

    }


//.....get screen width.........
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    int width=getScreenWidth();
//..........get screen height.........
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }



//.....gives boolean value if  vehicle has to move left or right.............
    public boolean move_direction(){
 //       Log.d("move Direction","pos_x: "+pos_x+" width: "+width);
        if(this.pos_x>(this.width/2)){
            return false;
        }else{
            return true;
        }

    }

//......... make vehicles move left/right.........
    public float move(boolean moveRight){
 //       Log.d("move Direction","pos_x: "+this.pos_x+" pos_left: "+this.pos_left);
        if(moveRight){
            this.pos_x+=5;
            this.pos_left+=5;
            this.pos_right+=5;
           // this.pos_bottom+=5;
        }else{
            this.pos_x-=5;
            this.pos_left-=5;
            this.pos_right-=5;
           // this.pos_bottom-=5;
        }
        return this.pos_x;
    }

    public boolean move_direction_dyn(){
        return true;
    }


    public float dyn_move(boolean moveRight){
        return 0.0f;
    }

}
