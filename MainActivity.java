package com.example.assignment4_mario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    mario mario = new mario();
    levelMap level_map = new levelMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton jump = (ImageButton)findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mario.smallHopFlag = 1;
                if(mario.hop == 0) {
                    mario.jump(mario, level_map);
                }
            }
        });

        ImageButton highjump = (ImageButton)findViewById(R.id.highjump);
        highjump.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mario.highHopFlag = 1;
                if(mario.hop == 0) {
                    mario.jump(mario, level_map);
                }
            }
        });

        ImageButton left_arrow = (ImageButton)findViewById(R.id.left_arrow);
        left_arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mario.move(level_map,mario,-1);
            }
        });

        ImageButton right_arrow = (ImageButton)findViewById(R.id.right_arrow);
        right_arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mario.move(level_map,mario,1);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT){
            mario.move(level_map,mario,1);
            return false;
        }
        else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT){
            mario.move(level_map,mario,-1);
            return false;
        }
        else if (keyCode == KeyEvent.KEYCODE_DPAD_UP){
            mario.smallHopFlag = 1;
            if(mario.hop == 0) {
                mario.jump(mario, level_map);
            }
            return false;
        }
        else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
            mario.highHopFlag = 1;
            if(mario.hop == 0) {
                mario.jump(mario, level_map);
            }
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
}
