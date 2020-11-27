package com.example.drawline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    DrawImage drawImage;
    ImageView gambar;
    Bitmap bmp;
    Canvas c;
    TextView lebar, tinggi,ambang,kecerahan;
    int lbr, tgi;
    int [][] bmpR,bmpG,bmpB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(R.layout.activity_main);
        lebar = (TextView) findViewById(R.id.txWidth);
        tinggi = (TextView) findViewById(R.id.txHeight);
        gambar = (ImageView) findViewById(R.id.imgGambar);
        ambang = findViewById(R.id.nAmbang);
        kecerahan = findViewById(R.id.nCerah);
        gambar.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        lbr = gambar.getWidth();
//        tgi = gambar.getHeight();
        lbr = gambar.getMeasuredWidth();
        tgi = gambar.getMeasuredHeight();

//        bmpR = new int[][];

//        gambar.getLayoutParams().height=400;
//        gambar.getLayoutParams().width=600;
//        setContentView(drawView);


    }
    public void btnBrightness (View view){
        lebar.setText("Height = "+tgi);
        tinggi.setText("Width = "+lbr);
        String nilaiCerah = kecerahan.getText().toString();
        int nCerah = Integer.parseInt(nilaiCerah);
        System.out.println("Berhasil");
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.luffy4);

        bmp = Bitmap.createBitmap(lbr, tgi, Bitmap.Config.RGB_565);
        c = new Canvas(bmp);
        gambar.draw(c);
        Paint p = new Paint();
        int piksel,A,R,G,B,abuabu,biner;

        for (int x = 0; x < lbr; x++){
            for (int y = 0; y < tgi; y++){
                piksel = bm.getPixel(x,y);
                A = Color.alpha(piksel);
                R = Color.red(piksel);
                G = Color.green(piksel);
                B = Color.blue(piksel);

                R = R + nCerah;
                if(R > 255) {R=255;}
                else if(R < 0){R=0;}

                G = G + nCerah;
                if(G > 255) {G=255;}
                else if(G < 0){G=0;}

                B = B + nCerah;
                if(B > 255) {B=255;}
                else if(B < 0){B=0;}

                p.setColor(Color.rgb(R,G,B));
                c.drawLine(x,y,x+lbr-100,y+tgi-100,p);
                gambar.setImageBitmap(bmp);
            }
        }
    }
    public void btnBiner (View view){

        lebar.setText("Height = "+tgi);
        tinggi.setText("Width = "+lbr);
        String nilaiAmbang = ambang.getText().toString();
        int nAmbang = Integer.parseInt(nilaiAmbang);
        System.out.println("Berhasil");
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.luffy4);

        bmp = Bitmap.createBitmap(lbr, tgi, Bitmap.Config.RGB_565);
        c = new Canvas(bmp);
        gambar.draw(c);
        Paint p = new Paint();
        int piksel,A,R,G,B,abuabu,biner;

        for (int x = 0; x < lbr; x++){
            for (int y = 0; y < tgi; y++){
                piksel = bm.getPixel(x,y);
                A = Color.alpha(piksel);
                R = Color.red(piksel);
                G = Color.green(piksel);
                B = Color.blue(piksel);
                abuabu = (R+G+B)/3;
                if(abuabu < nAmbang){biner = 0;}
                else {biner = 255;}

                p.setColor(Color.rgb(biner,biner,biner));
                c.drawLine(x,y,x+lbr-100,y+tgi-100,p);
                gambar.setImageBitmap(bmp);
            }
        }
    }

}