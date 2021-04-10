package com.teamx.farmily.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.teamx.farmily.R;

public class SplashScreen extends AppCompatActivity {
    ImageView ivFarmily;
    RelativeLayout relativeLayout;
    Animation ivAnimation, layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ivAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_to_top);


        ivFarmily = findViewById(R.id.iv_farmily);
        relativeLayout = findViewById(R.id.relSplash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivFarmily.setVisibility(View.VISIBLE);
                        ivFarmily.setAnimation(ivAnimation);
                    }
                }, 900);
            }
        }, 500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, IntroActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}