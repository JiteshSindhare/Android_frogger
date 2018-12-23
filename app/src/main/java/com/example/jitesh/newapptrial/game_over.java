package com.example.jitesh.newapptrial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.AttributedCharacterIterator;

public class game_over extends View {

    public game_over(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }

    protected  void onDraw(Canvas canvas){
        Paint write=new Paint();
        write.setStrokeWidth(20);
        canvas.drawText("Game Over",400,400,write);

    }
}
