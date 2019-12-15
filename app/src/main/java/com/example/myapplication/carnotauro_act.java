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


public class carnotauro_act extends AppCompatActivity {


    TextView txt_a,txt_a2, txt_o2, txt_u,txt_o;
    TextView txt_a_target, txt_a2_target, txt_o2_target, txt_u_target, txt_o_target;
    ImageView dino_view;
    MediaPlayer player;
    int global_result = 0;
    private static Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnotauro);

        txt_a = (TextView) findViewById(R.id.txt_a);
        txt_a2 = (TextView) findViewById(R.id.txt_a2);
        txt_o2 = (TextView) findViewById(R.id.txt_o2);
        txt_o = (TextView) findViewById(R.id.txt_o);
        txt_u = (TextView) findViewById(R.id.txt_u);

        txt_a_target = (TextView) findViewById(R.id.txt_a_target);
        txt_a2_target = (TextView) findViewById(R.id.txt_a2_target);
        txt_o2_target = (TextView) findViewById(R.id.txt_o2_target);
        txt_o_target = (TextView) findViewById(R.id.txt_o_target);
        txt_u_target = (TextView) findViewById(R.id.txt_u_target);

        // listener to start the drag
        txt_a.setOnTouchListener(myTouch);
        txt_a2.setOnTouchListener(myTouch);
        txt_o2.setOnTouchListener(myTouch);
        txt_o.setOnTouchListener(myTouch);
        txt_u.setOnTouchListener(myTouch);

        //listener to play all dino name
        dino_view = findViewById(R.id.dino_view);
        dino_view.setBackgroundResource(R.drawable.carnotauro);
        dino_view.setOnClickListener(clickListener);

        //listener to target have the dropping analyzed
        txt_a_target.setOnDragListener(dragListener_a);
        txt_a2_target.setOnDragListener(dragListener_a2);
        txt_o2_target.setOnDragListener(dragListener_o2);
        txt_o_target.setOnDragListener(dragListener_o);
        txt_u_target.setOnDragListener(dragListener_u);

        play_carnotauro(null);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play_carnotauro(v);
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


    public void play_car(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.car);
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

    public void play_no(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.no);
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


    public void play_tau(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.tau);
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
    public void play_carnotauro(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.carnotauro);
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

    public void play_ro(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.ro);
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
                        play_car(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };
    View.OnDragListener dragListener_a2 = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_a2) {
                        txt_a2_target.setText("a");
                        txt_a2.setText("");
                        txt_a2.setVisibility(View.INVISIBLE);
                        play_tau(view);
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
                        play_tau(view);
                        global_result++;
                        timer.schedule(new checkResult(),3000);

                    }

            }
            return true;
        }

    };


    View.OnDragListener dragListener_o2 = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.txt_o2) {
                        txt_o2_target.setText("o");
                        txt_o2.setVisibility(View.INVISIBLE);
                        txt_o2.setText("");
                        play_ro(view);
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
                        play_no(view);
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

            if (global_result == 5) {
                global_result = 0;
                play_carnotauro(null);
                SystemClock.sleep(1000);
                startActivity(new Intent(carnotauro_act.this, funquiossauro_act.class));

            }

        }
    }

}


