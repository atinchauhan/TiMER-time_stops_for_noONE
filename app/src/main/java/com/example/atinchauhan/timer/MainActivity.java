package com.example.atinchauhan.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    boolean active=false;
    Button button;
    CountDownTimer countDownTimer;

    public void reset()
    {
        textView.setText("00:30");
        seekBar.setProgress(30);
        seekBar.setEnabled(true);
        countDownTimer.cancel();
        button.setText("GO");
        active=false;
    }
    public void buttonClicked(View v){
        if(active) {
            reset();
                    }
        else
                   {
            active = true;
            seekBar.setEnabled(false);
            button.setText("STOP!");

       countDownTimer= new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {

            @Override
            public void onTick(long l)
            {
                update((int) l / 1000);

            }

            @Override
            public void onFinish()
            {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                mediaPlayer.start();
                reset();
            }
        }.start();

    }

}
public void update(int j)
{
    int minutes=j/60;
    int seconds=j%60;

    String sec=Integer.toString(seconds);
    String min=Integer.toString(minutes);

    if(seconds<=9)
    {
        sec="0"+sec;
    }
    if(minutes<=9)
    {
        min="0"+min;
    }
   /* if(sec.equals("0"))
    {
        sec="00";
    }
    if(sec.equals("1"))
    {
        sec="01";
    }
    if(sec.equals("2"))
    {
        sec="02";
    }
    if(sec.equals("3"))
    {
        sec="03";
    }
    if(sec.equals("4"))
    {
        sec="04";
    }
    if(sec.equals("5"))
    {
        sec="05";
    }
    if(sec.equals("6"))
    {
        sec="06";
    }
    if(sec.equals("7"))
    {
        sec="07";
    }
    if(sec.equals("8"))
    {
        sec="08";
    }
    if(sec.equals("9"))
    {
        sec="09";
    }
    if(min.equals("0"))
    {
        min="00";
    }
    if(min.equals("1"))
    {
        min="01";
    }
    if(min.equals("2"))
    {
        min="02";
    }
    if(min.equals("3"))
    {
        min="03";
    }
    if(min.equals("4"))
    {
        min="04";
    }
    if(min.equals("5"))
    {
        min="05";
    }
    if(min.equals("6"))
    {
        min="06";
    }
    if(min.equals("7"))
    {
        min="07";
    }
    if(min.equals("8"))
    {
        min="08";
    }
    if(min.equals("9"))
    {
        min="09";
    }*/
    textView.setText(min+":"+sec);

}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         seekBar=findViewById(R.id.seekBar);
         textView=findViewById(R.id.textView);
         button=findViewById(R.id.button);
         seekBar.setMax(600);
         seekBar.setProgress(30);
         seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
             update(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
