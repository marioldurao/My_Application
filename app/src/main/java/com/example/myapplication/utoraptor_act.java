package com.example.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class utoraptor_act extends AppCompatActivity {


    TextView txt_a, txt_e, txt_i,txt_o;
    TextView txt_a_target, txt_e_target, txt_i_target, txt_o_target;
    ImageView dino_view;
    MediaPlayer player;
    int global_result = 0;
    private static Timer timer = new Timer();
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utoraptor);
        ctx = this;

        txt_a = (TextView) findViewById(R.id.txt_a);
        txt_e = (TextView) findViewById(R.id.txt_e);
        txt_o = (TextView) findViewById(R.id.txt_o);

        txt_a_target = (TextView) findViewById(R.id.txt_a__target);
        txt_e_target = (TextView) findViewById(R.id.txt_e_target);
        txt_o_target = (TextView) findViewById(R.id.txt_o_target);

        // listener to start the drag
        txt_a.setOnTouchListener(myTouch);
        txt_e.setOnTouchListener(myTouch);
        txt_o.setOnTouchListener(myTouch);

        //listener to play all dino name
        dino_view = findViewById(R.id.dino_view);
        dino_view.setBackgroundResource(R.drawable.utoraptor);
        dino_view.setOnClickListener(clickListener);

        //listener to target have the dropping analyzed
        txt_a_target.setOnDragListener(dragListener_a);
        txt_e_target.setOnDragListener(dragListener_e);
        txt_o_target.setOnDragListener(dragListener_o);

        play_medoraptor(null);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play_medoraptor(v);
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


    public void play_a(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.a);
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

    public void play_e(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.e);
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
    public void play_medoraptor(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.medoraptor);
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

    public void play_me(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.me);
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
    public void play_do(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.doo);
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


    public void play_ra(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.ra);
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
                        play_ra(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };

    View.OnDragListener dragListener_e = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_e) {
                        txt_e_target.setText("e");
                        txt_e.setVisibility(View.INVISIBLE);
                        txt_e.setText("");
                        play_me(view);
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
                        play_do(view);
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

            if (global_result == 3) {
                global_result = 0;
         //       play_medoraptor(null);
         //       SystemClock.sleep(1000);
                startActivity(new Intent(utoraptor_act.this, medoraptor_act.class));

            }

        }
    }

}


