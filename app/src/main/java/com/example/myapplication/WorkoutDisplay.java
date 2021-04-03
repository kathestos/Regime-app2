package com.example.myapplication;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

public class WorkoutDisplay extends AppCompatActivity {

    ArrayList<Integer> playlist = new ArrayList<>();
    int i = 0;
    SeekBar mSeekBar;
    TextView totTime;
    TextView curTime;
    ImageView nextIcon;
    ImageView prevIcon;
    ImageView play;
    ImageView pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout_display);

        ArrayList<String> lista = getIntent().getExtras().getStringArrayList("lista");

        String[] sklekovi = getResources().getStringArray(R.array.sklekovi);
        String[] stanga_ruke = getResources().getStringArray(R.array.stanga_ruke);
        String[] sklek_vjestine = getResources().getStringArray(R.array.sklek_vjestine);
        String[] sklek_stabilnost = getResources().getStringArray(R.array.sklek_stabilnost);
        String[] ruke = getResources().getStringArray(R.array.ruke);
        String[] sklek_kretanje = getResources().getStringArray(R.array.sklek_kretanje);

        curTime = findViewById(R.id.curTime);
        nextIcon = findViewById(R.id.nextIcon);
        prevIcon = findViewById(R.id.prevIcon);

        TextView listaVjezbi = findViewById(R.id.lista_vjezbi);
        for (String temp : lista) {
            listaVjezbi.append(temp);
            listaVjezbi.append("\n");

//            if (temp.equals("prsa_zagrijavanje")) playlist.add(R.raw.prsa_zagrijavanje); TODO uncomment

            if (temp.equals(sklekovi[0])) {
                playlist.add(R.raw.norm_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[1])) {
                playlist.add(R.raw.uski_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[2])) {
                playlist.add(R.raw.siroki_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[3])) {
                playlist.add(R.raw.krizni_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[4])) {
                playlist.add(R.raw.prednji_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[5])) {
                playlist.add(R.raw.nagnuti_sklek);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(stanga_ruke[0])) {
                playlist.add(R.raw.siroko_100);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[1])) {
                playlist.add(R.raw.usko_80);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[2])) {
                playlist.add(R.raw.siroko_90);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[3])) {
                playlist.add(R.raw.usko_70);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[4])) {
                playlist.add(R.raw.siroko_80);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[5])) {
                playlist.add(R.raw.usko_60);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[6])) {
                playlist.add(R.raw.siroko_70);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[7])) {
                playlist.add(R.raw.usko_50);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[8])) {
                playlist.add(R.raw.obje_ruke);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(sklek_vjestine[0])) {
                playlist.add(R.raw.stoj);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[1])) {
                playlist.add(R.raw.uvuceni_planche);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[2])) {
                playlist.add(R.raw.hindu);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[3])) {
                playlist.add(R.raw.jedna_ruka);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[4])) {
                playlist.add(R.raw.nagib);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(sklek_stabilnost[0])) {
                playlist.add(R.raw.ruka_gore);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_stabilnost[1])) {
                playlist.add(R.raw.ruka_ispred);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_stabilnost[2])) {
                playlist.add(R.raw.ruka_iza);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_stabilnost[3])) {
                playlist.add(R.raw.dizanje_ramena);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(ruke[0])) {
                playlist.add(R.raw.ruke_sastrane);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(ruke[1])) {
                playlist.add(R.raw.ruke_iza);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(ruke[2])) {
                playlist.add(R.raw.ruke_iza_tijelo);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(ruke[3])) {
                playlist.add(R.raw.ruke_ispred);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(ruke[4])) {
                playlist.add(R.raw.jedna_ruka_iza);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(sklek_kretanje[0])) {
                playlist.add(R.raw.sklek_ustranu);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_kretanje[1])) {
                playlist.add(R.raw.gore_dolje_sklek);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_kretanje[2])) {
                playlist.add(R.raw.guster);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_kretanje[3])) {
                playlist.add(R.raw.spori_sklek);
                playlist.add(R.raw.sec20);
            }

//            if (temp.equals("prsa_rastezanje")) playlist.add(R.raw.prsa_rastezanje); TODO uncomment
        }

        play = findViewById(R.id.playMp3);
        pause = findViewById(R.id.pauseMp3);

        play.setOnClickListener(v -> playNext(pause));
    }

    void playNext(ImageView pause) {

        TextView nazivVjezbe = findViewById(R.id.naziv_vjezbe);
        GifImageView gif = findViewById(R.id.gif);

        String[] sklekovi = getResources().getStringArray(R.array.sklekovi);
        String[] stanga_ruke = getResources().getStringArray(R.array.stanga_ruke);
        String[] sklek_vjestine = getResources().getStringArray(R.array.sklek_vjestine);
        String[] sklek_stabilnost = getResources().getStringArray(R.array.sklek_stabilnost);
        String[] ruke = getResources().getStringArray(R.array.ruke);
        String[] sklek_kretanje = getResources().getStringArray(R.array.sklek_kretanje);

        mSeekBar = findViewById(R.id.mSeekBar);
        totTime = findViewById(R.id.totalTime);

        if (i==1) {
            play.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.VISIBLE);
        }

        if (i < playlist.size()) {
            MediaPlayer mp = MediaPlayer.create(this, playlist.get(i++));

            mp.setOnPreparedListener(mp1 -> {
                String totalTime = createTimeLabel(mp.getDuration());
                totTime.setText(totalTime);
                mSeekBar.setMax(mp.getDuration());
                mp.start();

                if (playlist.get(i - 1).equals(R.raw.norm_sklek)) {
                    nazivVjezbe.setText(sklekovi[0]);
                    gif.setImageResource(R.drawable.sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.siroko_100)) {
                    nazivVjezbe.setText(stanga_ruke[0]);
                    gif.setImageResource(R.drawable.buba);
                }
                if (playlist.get(i - 1).equals(R.raw.stoj)) {
                    nazivVjezbe.setText(sklek_vjestine[0]);
                    gif.setImageResource(R.drawable.stoj);
                }
            });

            mp.setOnCompletionListener(vv -> playNext(pause));

            mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        mp.seekTo(progress);
                        mSeekBar.setProgress(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });

            new Thread(() -> {
                while (mp != null) {
                    try {
                        if (mp.isPlaying()) {
                            Message msg = new Message();
                            msg.what = mp.getCurrentPosition();
                            handler.sendMessage(msg);
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            nextIcon.setOnClickListener(v -> {
                if (i < playlist.size()) {
                    mp.stop();
                    playNext(pause);
                }
            });

            prevIcon.setOnClickListener(v -> {
                mp.stop();
                i -= 2;
                playNext(pause);
            });

            pausePlay(pause, mp);
        }
    }

    void pausePlay(ImageView pause, MediaPlayer mp) {
        pause.setOnClickListener(vv -> {
            mp.pause();
            pause.setImageResource(R.drawable.play);
            pause.setOnClickListener(vvv -> {
                mp.start();
                pause.setImageResource(R.drawable.pause);
                pausePlay(pause, mp);
            });
        });
    }

    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;
        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;
        return timeLabel;
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int current_position = msg.what;
            mSeekBar.setProgress(current_position);
            String cTime = createTimeLabel(current_position);
            curTime.setText(cTime);
        }
    };

}