package com.example.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class funquiossauro_act extends AppCompatActivity {


    TextView txt_a, txt_i, txt_u,txt_o;
    TextView txt_a_target, txt_i_target, txt_u_target, txt_o_target;
    ImageView dino_view;
    MediaPlayer player;
    int global_result = 0;
    private static Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funqiossauro);

        txt_a = (TextView) findViewById(R.id.txt_a);
        txt_i = (TextView) findViewById(R.id.txt_i);
        txt_o = (TextView) findViewById(R.id.txt_o);
        txt_u = (TextView) findViewById(R.id.txt_u);

        txt_a_target = (TextView) findViewById(R.id.txt_a__target);
        txt_i_target = (TextView) findViewById(R.id.txt_i_target);
        txt_o_target = (TextView) findViewById(R.id.txt_o_target);
        txt_u_target = (TextView) findViewById(R.id.txt_u_target);

        // listener to start the drag
        txt_a.setOnTouchListener(myTouch);
        txt_i.setOnTouchListener(myTouch);
        txt_o.setOnTouchListener(myTouch);
        txt_u.setOnTouchListener(myTouch);

        //listener to play all dino name
        dino_view = findViewById(R.id.dino_view);
        dino_view.setBackgroundResource(R.drawable.funquiossauro);
        dino_view.setOnClickListener(clickListener);

        //listener to target have the dropping analyzed
        txt_a_target.setOnDragListener(dragListener_a);
        txt_i_target.setOnDragListener(dragListener_i);
        txt_o_target.setOnDragListener(dragListener_o);
        txt_u_target.setOnDragListener(dragListener_u);

        play_funquiossauro(null);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play_funquiossauro(v);
        }
    };



    View.OnTouchListener myTouch = new View.OnTouchListener(){


        @Override
        public boolean onTouch(View v, MotionEvent event) {

            ClipData clipData = ClipData.newPlainText("","");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);

            return true;
        }
    };


    public void play_fun(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.fun);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                }
            });
            player.start();
        }

    }

    public void play_qui(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.qui);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                }
            });
            player.start();
        }

    }


    public void play_o(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.o);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                }
            });
            player.start();
        }

    }
    public void play_funquiossauro(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.funquiossauro);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                }
            });
            player.start();
        }

    }

    public void play_sau(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.sau);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                    player = null;
                }
            });
            player.start();
        }

    }



    View.OnDragListener dragListener_a = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_a) {
                        txt_a_target.setText("a");
                        txt_a.setText("");
                        txt_a.setVisibility(View.INVISIBLE);
                        play_sau(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };

    View.OnDragListener dragListener_u = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_u) {
                        txt_u_target.setText("u");
                        txt_u.setVisibility(View.INVISIBLE);
                        txt_u.setText("");
                        play_fun(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };


    View.OnDragListener dragListener_i = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_i) {
                        txt_i_target.setText("i");
                        txt_i.setVisibility(View.INVISIBLE);
                        txt_i.setText("");
                        play_qui(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };

    View.OnDragListener dragListener_o = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_o) {
                        txt_o_target.setText("o");
                        txt_o.setVisibility(View.INVISIBLE);
                        txt_o.setText("");
                        play_o(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };

    private class checkResult extends TimerTask
    {
        public void run() {

            if (global_result == 4) {
                global_result = 0;
                play_funquiossauro(null);
                SystemClock.sleep(1000);
                startActivity(new Intent(funquiossauro_act.this, utoraptor_act.class));

            }

        }
    }

}


