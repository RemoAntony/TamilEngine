package com.antony.remo.tamilengine;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class AndroidTextToSpeechActivity extends Activity implements
        TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_text_to_speech);

        tts = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.btnSpeakk);

        txtText = (EditText) findViewById(R.id.txtText);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    speakOut();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                try {
                    speakOut();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() throws Exception {

        String text = txtText.getText().toString();
        for (int i = 0; i < text.length(); i++) {

            final String a_letter = Character.toString(text.charAt(i));
            //for(int j=0;j<10100000;j++);
            //new Handler().wait(1000);

                    if(a_letter.equals("1")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("2")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aa);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("3")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("4")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ee);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("5")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.u);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("6")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("7")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("8")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aa);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("9")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ai);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("0")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.o);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("a")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.oo);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("b")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.au);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("c")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.k);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("d")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.onru);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("e")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.irandu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("f")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.muunru);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("g")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.naanku);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("h")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ainthu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("i")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aaru);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("j")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.eezu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("k")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ettu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("l")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.onpathu);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("m")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.saiphar);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("n")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.k);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("o")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ng);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("p")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.c);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("q")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ng);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("r")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.t);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("s")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("t")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.t);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("u")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("v")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pa);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("w")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.m);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("x")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.y);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("y")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.r);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("z")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.l);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("!")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.va);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("@")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.z);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("#")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.l);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("$")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.r);
                        mediaPlayer.start();
                    }
                    if(a_letter.equals("%")) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                        mediaPlayer.start();
                    }

                }

    }
}