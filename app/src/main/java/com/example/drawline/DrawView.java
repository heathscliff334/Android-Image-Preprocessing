package com.example.drawline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class DrawView extends View {
    Paint paint = new Paint();
    TextView txtWidth,txtHeight;

    private void init(){
//        paint.setColor((Color.BLACK));

        txtHeight = (TextView) findViewById(R.id.txHeight);
        txtWidth = (TextView) findViewById(R.id.txWidth);
//        txtHeight.setText("Height :");
//        txtWidth.setText("Width :");
//        paint.setColor(Color.BLACK);
    }
    public DrawView(Context context){
        super(context);
        init();
    }
    public DrawView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }
    public DrawView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas){
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.luffy);

        int pixelColor = bm.getPixel(10,10);
        int width = bm.getWidth();
        int height = bm.getHeight();

        Bitmap bmOut = Bitmap.createBitmap(width, height, bm.getConfig());
        int A,R,G,B,abuabu;
        int piksel;
        int value = 80;

        for (int x = 1; x < width-1; x++){
            for (int y = 1; y < height-1; y++){
                piksel = bm.getPixel(x,y);
                A = Color.alpha(piksel);
                R = Color.red(piksel);
                G = Color.green(piksel);
                B = Color.blue(piksel);
//                abuabu = (R+G+B)/3;

//                R += value;
//                if(R>255) {R=255;}
//                else if (R<0) {R=0;}
//
//                G += value;
//                if(G>255) {G=255;}
//                else if (G<0) {G=0;}
//
//                B += value;
//                if(B>255) {B=255;}
//                else if (B<0) {B=0;}

//                bmOut.setPixel(x,y,Color.argb(A,R,G,B));
                paint.setColor(Color.rgb(R,G,B));
                canvas.drawLine(x+width,y+height,x+width,y+height,paint);
//                canvas.drawRGB(R,G,B);
            }
        }

        canvas.drawLine(20,100,140,30,paint);
        canvas.drawText("Height"+height,30,120,paint);
//        canvas.drawLine(0,0,20,20,paint);
//        canvas.drawLine(20,0,0,20,paint);
    }
}
