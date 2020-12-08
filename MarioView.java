package com.example.assignment4_mario;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioTrack;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Matrix;

import java.util.concurrent.TimeUnit;

public class MarioView extends View {


    public MarioView(Context context){
        super (context);
        init(null);
    }
    public MarioView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(attrs);
    }
    public MarioView(Context context,AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        init(attrs);
    }
    private void init(@Nullable AttributeSet set){

    }
    mario mario = new mario();
    levelMap level_map = new levelMap();

    int timeout = 1000; //1 second
    int goombaMove = 0;
    int pPlantMove = 0;

    @Override
    public void onDraw(Canvas canvas){

        Bitmap Mario;
        Bitmap Brick;
        Bitmap Goomba;
        Bitmap Pipe;
        Bitmap Piranha;
        Bitmap Shroom;
        Bitmap ItemBrick;
        Bitmap Star;
        Bitmap Coin;
        Bitmap Block;
        Bitmap MarioStar;
        Bitmap BigMario;
        Bitmap MarioJump;
        Bitmap MarioStarJump;
        Bitmap Flag;

        Mario = BitmapFactory.decodeResource(getResources(),R.drawable.mario);
        MarioStar = BitmapFactory.decodeResource(getResources(),R.drawable.bigstarmario);
        MarioStarJump = BitmapFactory.decodeResource(getResources(),R.drawable.starjumpmario);
        BigMario = BitmapFactory.decodeResource(getResources(),R.drawable.bigmario);
        MarioJump = BitmapFactory.decodeResource(getResources(),R.drawable.mariojump);
        Block = BitmapFactory.decodeResource(getResources(),R.drawable.block);
        Brick = BitmapFactory.decodeResource(getResources(),R.drawable.brick);
        Goomba = BitmapFactory.decodeResource(getResources(),R.drawable.goomba);
        Pipe = BitmapFactory.decodeResource(getResources(),R.drawable.pipe);
        Piranha = BitmapFactory.decodeResource(getResources(),R.drawable.piranhaplant);
        Shroom = BitmapFactory.decodeResource(getResources(),R.drawable.shroom);
        ItemBrick = BitmapFactory.decodeResource(getResources(),R.drawable.itemblock);
        Star = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        Coin = BitmapFactory.decodeResource(getResources(),R.drawable.coin);
        Flag = BitmapFactory.decodeResource(getResources(),R.drawable.flag);




        Paint nothing = new Paint();
        nothing.setColor(0XFF6B8CFF);

        Paint block = new Paint();
        block.setColor(0XFFBA6030);

        Paint pipe = new Paint();
        pipe.setColor(Color.GREEN);

        Paint flag = new Paint();
        flag.setColor(0XFFFCC544);

        Paint goomba = new Paint();
        goomba.setColor(0XFF2b1d0e);

        Paint marioChar = new Paint();
        marioChar.setColor(Color.WHITE);

        Paint brick = new Paint();
        brick.setColor(0XFF662b07);

        Paint itembrick = new Paint();
        itembrick.setColor(Color.YELLOW);

        Paint shroom = new Paint();
        shroom.setColor(0XFF8b0000);

        Paint coin = new Paint();
        coin.setColor(0XFFFFD700);

        Paint star = new Paint();
        star.setColor(0XFFccff00);

        Paint pplant = new Paint();
        pplant.setColor(0XFF008040);



        mario.updateMarioPosition(level_map, mario);
        if(mario.hop == 0){
            mario.land(mario,level_map);
        }

        while(mario.scrollScreen(level_map)){
            mario.updateBounds();
        }

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if(mario.lives != 0)
                        TimeUnit.MILLISECONDS.sleep(timeout);
                    else if(mario.lives == 0)
                        TimeUnit.MINUTES.sleep(timeout);
                } catch (InterruptedException e) {

                }

                if(mario.hop != 0) {
                    mario.jump(mario, level_map);
                }

                if(goombaMove % 4 == 0)
                    level_map.moveGoombasLeft();
                else if(goombaMove % 4 == 1) {
                    level_map.moveGoombasRight();
                }
                else if(goombaMove % 4 == 2)
                    level_map.moveGoombasRight();
                else if(goombaMove % 4 == 3) {
                    level_map.moveGoombasLeft();
                }

                if(pPlantMove % 6 != 3 && pPlantMove % 6 != 4){
                    level_map.movePirahnasUp();
                }
                else if(pPlantMove % 8 == 3 || pPlantMove % 6 == 4){
                    level_map.movePirahnasDown();
                }

                mario.time--;
                goombaMove++;
                pPlantMove++;
                mario.checkStarTimeout(mario);

                if(mario.time == 0){
                    mario = new mario();
                    mario.shrink(mario, level_map);
                    mario.currentMarioXPosition--;
                }

                mario.onHit(mario, level_map, mario.currentMarioYPosition, mario.currentMarioXPosition, 0);
                mario.onHit(mario, level_map, mario.currentMarioYPosition, mario.currentMarioXPosition, -1);
                mario.onHit(mario, level_map, mario.currentMarioYPosition, mario.currentMarioXPosition, 1);
            }
        });



        for (int i = level_map.currentMap.length - 1; i >= 0; i--) {
            for (int j = mario.leftScreenBound; j < mario.rightScreenBound; j++) {
                int gm = 80;
                int top = (level_map.currentMap.length - 1  - i) * gm;
                int bottom = top + gm;
                int left = ((j-mario.leftScreenBound) * gm) + 300;
                int right = left + gm;

                Rect rectangle = new Rect(left,top,right,bottom);
                Rect bigrectangle = new Rect(left,top-gm,right,bottom);
                Rect flagrect = new Rect(left,top-(4*gm),right,bottom);



                if (level_map.currentMap[i][j] == pixel_type.NOTHING || level_map.currentMap[i][j] == pixel_type.VOID) {
                    canvas.drawRect(left, top, right, bottom, nothing);
                } else if (level_map.currentMap[i][j] == pixel_type.BLOCK) {
                    canvas.drawBitmap(Block,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, block);
                } else if (level_map.currentMap[i][j] == pixel_type.PIPE || level_map.currentMap[i][j] == pixel_type.DEADPIPE) {
                    canvas.drawBitmap(Pipe,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, pipe);
                } else if (level_map.currentMap[i][j] == pixel_type.FLAG) {
                    canvas.drawBitmap(Flag,null,flagrect,null);
                    //canvas.drawRect(left, top, rigaht, bottom, flag);
                } else if (level_map.currentMap[i][j] == pixel_type.GOOMBA) {
                    canvas.drawBitmap(Goomba,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, goomba);
                } else if (level_map.currentMap[i][j] == pixel_type.MARIO) {
                    if(level_map.currentMap[i-1][j] != pixel_type.NOTHING) {
                        if (mario.hasStar()) {
                            if (mario.getCurrentState() == "BIG" && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw big star mario
                                canvas.drawBitmap(MarioStar,null,bigrectangle,null);
                            } else {
                                canvas.drawBitmap(MarioStar,null,rectangle,null);
                                //draw small star mario
                            }
                        } else {
                            if (mario.getCurrentState() == "BIG"  && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw big mario
                                canvas.drawBitmap(Mario,null,bigrectangle,null);
                            } else {
                                canvas.drawBitmap(Mario,null,rectangle,null);
                                //draw small mario
                            }
                        }
                    }
                    else if (level_map.currentMap[i-1][j] == pixel_type.NOTHING ){
                        if (mario.hasStar()) {
                            if (mario.getCurrentState() == "BIG" && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw jump big star mario
                                canvas.drawBitmap(MarioStarJump,null,bigrectangle,null);
                            } else {
                                canvas.drawBitmap(MarioStarJump,null,rectangle,null);
                                //draw jump small star mario
                            }
                        } else {
                            if (mario.getCurrentState() == "BIG"  && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw jump big mario
                                canvas.drawBitmap(MarioJump,null,bigrectangle,null);
                            } else {
                                canvas.drawBitmap(MarioJump,null,rectangle,null);
                                //draw jump small mario
                            }
                        }
                    }
                    else if(level_map.currentMap[i-2][j] == pixel_type.NOTHING){
                        if (mario.hasStar()) {
                            if (mario.getCurrentState() == "BIG" && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw jump big star mario
                                canvas.drawBitmap(MarioStarJump,null,bigrectangle,null);
                            } else {
                                //draw jump small star mario
                                canvas.drawBitmap(MarioStarJump,null,rectangle,null);
                            }
                        } else {
                            if (mario.getCurrentState() == "BIG"  && level_map.currentMap[i + 1][j] == pixel_type.MARIO) {
                                //draw jump big mario
                                canvas.drawBitmap(MarioJump,null,bigrectangle,null);
                            } else {
                                canvas.drawBitmap(MarioJump,null,rectangle,null);
                                //draw jump small mario
                            }
                        }
                    }
                    else{
                        if(mario.getCurrentState() == "BIG"){
                            canvas.drawBitmap(Mario,null,bigrectangle,null);
                        }else {
                            canvas.drawBitmap(Mario, null, rectangle, null);
                            canvas.drawRect(left, top + gm, right, bottom, nothing);
                        }
                    }
                }else if (level_map.currentMap[i][j] == pixel_type.BRICK) {
                    canvas.drawBitmap(Brick,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, brick);
                }else if (level_map.currentMap[i][j] == pixel_type.ITEMBRICK_M || level_map.currentMap[i][j] == pixel_type.ITEMBRICK_S) {
                    canvas.drawBitmap(ItemBrick,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom,itembrick);
                }else if (level_map.currentMap[i][j] == pixel_type.MUSHROOM) {
                    canvas.drawBitmap(Shroom,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, shroom);
                }else if(level_map.currentMap[i][j] == pixel_type.COIN){
                    canvas.drawBitmap(Coin,null,rectangle,nothing);
                    //canvas.drawRect(left, top, right, bottom, coin);
                }else if(level_map.currentMap[i][j] == pixel_type.STAR){
                    canvas.drawBitmap(Star,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, star);
                }else if(level_map.currentMap[i][j] == pixel_type.PIRAHNA_PLANT){
                    canvas.drawBitmap(Piranha,null,rectangle,null);
                    //canvas.drawRect(left, top, right, bottom, pplant);
                }

            }
        }
        Paint score = new Paint();
        score.setColor(Color.WHITE);
        score.setTextSize(40);

        canvas.drawText("Score: ",100,100,score);
        canvas.drawText(Integer.toString(mario.score),100,150,score);

        canvas.drawText("Lives:",1500,100,score);
        canvas.drawText(Integer.toString(mario.lives),1500,150,score);

        canvas.drawText("Level:",100,250,score);
        canvas.drawText(Integer.toString(mario.level + 1),100,300,score);

        canvas.drawText("Time:", 1500, 250, score);
        canvas.drawText(Integer.toString(mario.time),1500,300,score);

        invalidate();
    }


}
