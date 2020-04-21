package com.example.truthndare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    Button button;
    int initialDirection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottle=findViewById(R.id.bottle);
       button=findViewById(R.id.button);



     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             rotatebottle();
         }
     });
    }

    private void rotatebottle()
    {
        Random r = new Random();
        int newDirection = r.nextInt(3600);

        float pivotX = bottle.getWidth()/2;
        float pivotY = bottle.getHeight()/2;


        Animation rotate = new RotateAnimation(initialDirection, newDirection, pivotX , pivotY);
        //rotate.setDuration(2000);

        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
        bottle.startAnimation(rotate);
        initialDirection=newDirection;

    }
}
