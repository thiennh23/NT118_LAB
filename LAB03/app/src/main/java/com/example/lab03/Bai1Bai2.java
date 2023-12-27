package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.animation.ScaleAnimation;
import android.view.animation.BounceInterpolator;


public class Bai1Bai2 extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        findViewsByIds();
        initVariables();

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "ivUitLogo clicked");

                Intent intent = new Intent(Bai1Bai2.this, Bai3.class);
                startActivity(intent);
            }
        });

        //ANIMATION USING CODE FUNCTION
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnCombineCode, initCombinedAnimation());

        //ANIMATION USING XML FILES
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    private Animation initCombinedAnimation(){
        AnimationSet animationSet = new AnimationSet(true);

        // Scale-up animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 3.0f,  // From X and Y scale (start with original size)
                1.0f, 3.0f,  // To X and Y scale (scale up by a factor of 3)
                Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot X (center of the view)
                Animation.RELATIVE_TO_SELF, 0.5f   // Pivot Y (center of the view)
        );
        scaleAnimation.setDuration(4000);
        scaleAnimation.setFillAfter(true);

        // Rotate animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,  // From and to degrees (rotate 360 degrees)
                Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot X (center of the view)
                Animation.RELATIVE_TO_SELF, 0.5f   // Pivot Y (center of the view)
        );
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setRepeatMode(Animation.RESTART);

        // Add animations to the set
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        // Set interpolator
        animationSet.setInterpolator(new LinearInterpolator());

        // Set fill after
        animationSet.setFillAfter(true);

        // Set animation listener if needed
        animationSet.setAnimationListener(animationListener);

        return animationSet;
    }


    private Animation initZoomOutAnimation(){
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, 0.5f,  // From X and Y scale (start with original size)
                1.0f, 0.5f,  // To X and Y scale (zoom out by a factor of 0.5)
                Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot X (center of the view)
                Animation.RELATIVE_TO_SELF, 0.5f   // Pivot Y (center of the view)
        );

        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }


    private Animation initZoomInAnimation(){
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, 3.0f,  // From X and Y scale (start with original size)
                1.0f, 3.0f,  // To X and Y scale (scale up by a factor of 3)
                Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot X (center of the view)
                Animation.RELATIVE_TO_SELF, 0.5f   // Pivot Y (center of the view)
        );

        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }


    private Animation initSlideUpAnimation(){
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, 1.0f, // From X and Y scale (no scaling)
                1.0f, 0.0f  // To X and Y scale (shrink vertically to 0)
        );

        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }


    private Animation initRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(800); // Adjust the duration as needed
        rotateAnimation.setRepeatCount(2);

        return rotateAnimation;
    }


    private Animation initMoveAnimation(){
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.75f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f
        );

        animation.setDuration(800);
        animation.setFillAfter(true);
        animation.setInterpolator(new LinearInterpolator());
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeOutAnimation(){
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBounceAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1.0f, 1.0f, // Start and end scale X
                0.0f, 1.0f, // Start and end scale Y
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point X relative to view width
                Animation.RELATIVE_TO_SELF, 0.5f // Pivot point Y relative to view height
        );

        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setInterpolator(new BounceInterpolator()); // Use bounce interpolator

        return animation;
    }

    private Animation initFadeInAnimation(){
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBlinkAnimation(){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(3);
        anim.setAnimationListener(animationListener);
        anim.setFillAfter(true);
        return anim;
    }

    private void handleClickAnimationCode(Button btn, final Animation animation){
        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void handleClickAnimationXml(Button btn, int animId){
        final Animation animation = AnimationUtils.loadAnimation(Bai1Bai2.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }

}