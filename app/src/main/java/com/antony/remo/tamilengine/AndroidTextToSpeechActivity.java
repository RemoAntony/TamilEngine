package com.antony.remo.tamilengine;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class AndroidTextToSpeechActivity extends Activity implements
        TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    private MediaPlayer mediaPlayer;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_text_to_speech);

        tts = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.btnSpeakk);

        txtText = (EditText) findViewById(R.id.txtText);
        textView = (TextView) findViewById(R.id.actualtxt);
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
        Typeface t = Typeface.createFromAsset(getBaseContext().getAssets(), "fonts/SaiVrishintscii.ttf");
        textView.setTypeface(t);
        txtText.addTextChangedListener(passwordWatcher);
    }

    String acttxt = "";
    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            acttxt = "";
            if (s.length() == 0) {
                acttxt = "";
                textView.setVisibility(View.GONE);
            }
            else if (s.length() == 1) {
                String temp = txtText.getText().toString();
                char char1 = temp.charAt(0);
                if (char1 == 'n')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "க்");
                if (char1 == 'o')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ங்");
                if (char1 == 'p')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ச்");
                if (char1 == 'q')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஞ்");
                if (char1 == 'r')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ட்");
                if (char1 == 's')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ண்");
                if (char1 == 't')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "த்");
                if (char1 == 'u')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ந்");
                if (char1 == 'v')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ப்");
                if (char1 == 'w')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ம்");
                if (char1 == 'x')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ய்");
                if (char1 == 'y')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ர்");
                if (char1 == 'z')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ல்");
                if (char1 == '!')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "வ்");
                if (char1 == '@')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ழ்");
                if (char1 == '#')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ள்");
                if (char1 == '$')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ற்");
                if (char1 == '%')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ன்");

                if (char1 == '1')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "அ");
                if (char1 == '2')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஆ");
                if (char1 == '3')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "இ");
                if (char1 == '4')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஈ");
                if (char1 == '5')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "உ");
                if (char1 == '6')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஊ");
                if (char1 == '7')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "எ");
                if (char1 == '8')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஏ");
                if (char1 == '9')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஐ");
                if (char1 == '0')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஒ");
                if (char1 == 'a')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஓ");
                if (char1 == 'b')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஔ");
                if (char1 == 'c')
                    acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஃ");
            }
            else {
                acttxt = "";
                String temp = txtText.getText().toString();
                for (int i = 0; i < temp.length(); i++) {
                    char char1 = temp.charAt(i);
                    char char2=' ';
                    try {
                        char2 = temp.charAt(i + 1);
                    }catch (Exception e)
                    {
                        if (char1 == 'n')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "க்");
                        if (char1 == 'o')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ங்");
                        if (char1 == 'p')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ச்");
                        if (char1 == 'q')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஞ்");
                        if (char1 == 'r')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ட்");
                        if (char1 == 's')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ண்");
                        if (char1 == 't')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "த்");
                        if (char1 == 'u')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ந்");
                        if (char1 == 'v')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ப்");
                        if (char1 == 'w')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ம்");
                        if (char1 == 'x')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ய்");
                        if (char1 == 'y')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ர்");
                        if (char1 == 'z')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ல்");
                        if (char1 == '!')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "வ்");
                        if (char1 == '@')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ழ்");
                        if (char1 == '#')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ள்");
                        if (char1 == '$')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ற்");
                        if (char1 == '%')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ன்");
                        if (char1 == '1')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "அ");
                        if (char1 == '2')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஆ");
                        if (char1 == '3')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "இ");
                        if (char1 == '4')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஈ");
                        if (char1 == '5')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "உ");
                        if (char1 == '6')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஊ");
                        if (char1 == '7')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "எ");
                        if (char1 == '8')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஏ");
                        if (char1 == '9')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஐ");
                        if (char1 == '0')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஒ");
                        if (char1 == 'a')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஓ");
                        if (char1 == 'b')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஔ");
                        if (char1 == 'c')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஃ");
                        break;
                    }
                    if ((char1 == 'n' || char1 == 'o' || char1 == 'p' || char1 == 'q' || char1 == 'r' || char1 == 's' || char1 == 't' || char1 == 'u' || char1 == 'v' || char1 == 'w'
                            || char1 == 'x' || char1 == 'y' || char1 == 'z' || char1 == '!' || char1 == '@' || char1 == '#' || char1 == '$' || char1 == '%')) {
                        i++;



                        if (char1 == 'n') {
                            if (char2 == '1') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "க");
                            } else if (char2 == '2') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கா");
                            } else if (char2 == '3') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கி");
                            } else if (char2 == '4') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கீ");
                            } else if (char2 == '5') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கு");
                            } else if (char2 == '6') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கூ");
                            } else if (char2 == '7') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கெ");
                            } else if (char2 == '8') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கே");
                            } else if (char2 == '9') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கை");
                            } else if (char2 == '0') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கொ");
                            } else if (char2 == 'a') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கோ");
                            } else if (char2 == 'b') {
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "கௌ");
                            } else {
                                i--;
                                acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "க்");
                            }
                        }



                    } else {


                        if (char1 == '1')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "அ");
                        if (char1 == '2')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஆ");
                        if (char1 == '3')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "இ");
                        if (char1 == '4')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஈ");
                        if (char1 == '5')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "உ");
                        if (char1 == '6')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஊ");
                        if (char1 == '7')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "எ");
                        if (char1 == '8')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஏ");
                        if (char1 == '9')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஐ");
                        if (char1 == '0')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஒ");
                        if (char1 == 'a')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஓ");
                        if (char1 == 'b')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஔ");
                        if (char1 == 'c')
                            acttxt += TamilUtil.convertToTamil(TamilUtil.TSCII, "ஃ");
                    }
                }
            }
            textView.setText("You have entered : " + acttxt);
        }
    };

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

            if (a_letter.equals("1")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
                mediaPlayer.start();
            }
            if (a_letter.equals("2")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aa);
                mediaPlayer.start();
            }
            if (a_letter.equals("3")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e);
                mediaPlayer.start();
            }
            if (a_letter.equals("4")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ee);
                mediaPlayer.start();
            }
            if (a_letter.equals("5")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.u);
                mediaPlayer.start();
            }
            if (a_letter.equals("6")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uu);
                mediaPlayer.start();
            }
            if (a_letter.equals("7")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
                mediaPlayer.start();
            }
            if (a_letter.equals("8")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aa);
                mediaPlayer.start();
            }
            if (a_letter.equals("9")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ai);
                mediaPlayer.start();
            }
            if (a_letter.equals("0")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.o);
                mediaPlayer.start();
            }
            if (a_letter.equals("a")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.oo);
                mediaPlayer.start();
            }
            if (a_letter.equals("b")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.au);
                mediaPlayer.start();
            }
            if (a_letter.equals("c")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.k);
                mediaPlayer.start();
            }
            if (a_letter.equals("d")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.onru);
                mediaPlayer.start();
            }
            if (a_letter.equals("e")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.irandu);
                mediaPlayer.start();
            }
            if (a_letter.equals("f")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.muunru);
                mediaPlayer.start();
            }
            if (a_letter.equals("g")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.naanku);
                mediaPlayer.start();
            }
            if (a_letter.equals("h")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ainthu);
                mediaPlayer.start();
            }
            if (a_letter.equals("i")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aaru);
                mediaPlayer.start();
            }
            if (a_letter.equals("j")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.eezu);
                mediaPlayer.start();
            }
            if (a_letter.equals("k")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ettu);
                mediaPlayer.start();
            }
            if (a_letter.equals("l")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.onpathu);
                mediaPlayer.start();
            }
            if (a_letter.equals("m")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.saiphar);
                mediaPlayer.start();
            }
            if (a_letter.equals("n")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.k);
                mediaPlayer.start();
            }
            if (a_letter.equals("o")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ng);
                mediaPlayer.start();
            }
            if (a_letter.equals("p")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.c);
                mediaPlayer.start();
            }
            if (a_letter.equals("q")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ng);
                mediaPlayer.start();
            }
            if (a_letter.equals("r")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.t);
                mediaPlayer.start();
            }
            if (a_letter.equals("s")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                mediaPlayer.start();
            }
            if (a_letter.equals("t")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.t);
                mediaPlayer.start();
            }
            if (a_letter.equals("u")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                mediaPlayer.start();
            }
            if (a_letter.equals("v")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pa);
                mediaPlayer.start();
            }
            if (a_letter.equals("w")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.m);
                mediaPlayer.start();
            }
            if (a_letter.equals("x")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.y);
                mediaPlayer.start();
            }
            if (a_letter.equals("y")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.r);
                mediaPlayer.start();
            }
            if (a_letter.equals("z")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.l);
                mediaPlayer.start();
            }
            if (a_letter.equals("!")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.va);
                mediaPlayer.start();
            }
            if (a_letter.equals("@")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.z);
                mediaPlayer.start();
            }
            if (a_letter.equals("#")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.l);
                mediaPlayer.start();
            }
            if (a_letter.equals("$")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.r);
                mediaPlayer.start();
            }
            if (a_letter.equals("%")) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                mediaPlayer.start();
            }

        }

    }
}