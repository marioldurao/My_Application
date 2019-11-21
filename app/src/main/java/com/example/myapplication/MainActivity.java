package com.example.myapplication;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {


    TextView txt_a, txt_e, txt_i,txt_o;
    TextView txt_a_target, txt_e_target, txt_i_target, txt_o_target;
    ImageView dino_view;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_a = (TextView) findViewById(R.id.txt_a);
        txt_e = (TextView) findViewById(R.id.txt_e);
        txt_i = (TextView) findViewById(R.id.txt_i);
        txt_o = (TextView) findViewById(R.id.txt_o);

        txt_a_target = (TextView) findViewById(R.id.txt_a__target);
        txt_e_target = (TextView) findViewById(R.id.txt_e_target);
        txt_i_target = (TextView) findViewById(R.id.txt_i__target);
        txt_o_target = (TextView) findViewById(R.id.txt_o_target);

        // listener to start the drag
        txt_a.setOnTouchListener(myTouch);
        txt_e.setOnTouchListener(myTouch);
        txt_i.setOnTouchListener(myTouch);
        txt_o.setOnTouchListener(myTouch);

        //listener to play all dino name
        dino_view = findViewById(R.id.dino_view);
        dino_view.setBackgroundResource(R.drawable.velociraptor);
        dino_view.setOnClickListener(clickListener);

        //listener to target have the dropping analyzed
        txt_a_target.setOnDragListener(dragListener);
        txt_e_target.setOnDragListener(dragListener);
        txt_i_target.setOnDragListener(dragListener);
        txt_o_target.setOnDragListener(dragListener);

        play_velociraptor(null);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play_velociraptor(v);
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

//comment to check commit to git

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            switch(dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
//                case    DragEvent.ACTION_DRAG_STARTED:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt_a){
                        txt_a_target.setText("a");
                        txt_a.setText("");
                        //play_a(view);
                        play_ra(view);
                        //play_velociraptor(view);
                    }
                    if(view.getId() == R.id.txt_e){
                        txt_e_target.setText("e");
                        txt_e.setText("");
                        //play_e(view);
                        play_ve(view);

                    }

                    if(view.getId() == R.id.txt_i){
                        txt_i_target.setText("i");
                        txt_i.setText("");
                        //play_i(view);
                        play_ci(view);
                        //play_velociraptor(view);
                    }
                    if(view.getId() == R.id.txt_o){
                        txt_o_target.setText("o");
                        txt_o.setText("");
                        //play_o(view);
                        play_lo(view);
                        play_velociraptor(view);
                    }
                    break;

            }

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

    public void play_i(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.i);
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

    public void play_velociraptor(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.velociraptor);
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
    public void play_ve(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.ve);
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

    public void play_lo(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.lo);
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

    public void play_ci(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.ci);
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

}
