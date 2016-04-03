package com.antony.remo.tamilengine;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class SimpleIME extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;

    private boolean caps = false;

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                String code;
                if(primaryCode==981){
                    code = "1";

                }
                else if(primaryCode==982){
                    code = "2";
                }
                else if(primaryCode==983){
                    code = "3";
                }
                else  if(primaryCode==984){
                    code = "4";
                }
                else  if(primaryCode==985){
                    code = "5";
                }
                else if(primaryCode==986){
                    code = "6";
                }
                else if(primaryCode==987){
                    code = "7";
                }
                else if(primaryCode==988){
                    code = "8";
                }
                else if(primaryCode==989){
                    code = "9";
                }
                else if(primaryCode==990){
                    code = "0";
                }
                else if(primaryCode==991){
                    code = "a";
                }
                else if(primaryCode==992){
                    code = "b";
                }
                else if(primaryCode==993){
                    code = "c";
                }
                else if(primaryCode==49){
                    code = "d";
                }
                else if(primaryCode==50){
                    code = "e";
                }
                else if(primaryCode==51){
                    code = "f";
                }
                else if(primaryCode==52){
                    code = "g";
                }
                else if(primaryCode==53){
                    code = "h";
                }
                else if(primaryCode==54){
                    code = "i";
                }
                else if(primaryCode==55){
                    code = "j";
                }
                else if(primaryCode==56){
                    code = "k";
                }
                else if(primaryCode==57){
                    code = "l";
                }
                else if(primaryCode==58){
                    code = "m";
                }

                else if(primaryCode==100){
                    code = "n";
                }

                else if(primaryCode==101){
                    code = "o";
                }
                else if(primaryCode==102){
                    code = "p";
                }

                else if(primaryCode==103){
                    code = "q";
                }

                else if(primaryCode==104){
                    code = "r";
                }

                else if(primaryCode==105){
                    code = "s";
                }

                else if(primaryCode==106){
                    code = "t";
                }

                else if(primaryCode==107){
                    code = "u";
                }

                else if(primaryCode==108){
                    code = "v";
                }

                else if(primaryCode==109){
                    code = "w";
                }

                else if(primaryCode==110){
                    code = "x";
                }

                else if(primaryCode==111){
                    code = "y";
                }

                else if(primaryCode==112){
                    code = "z";
                }

                else if(primaryCode==113){
                    code = "!";
                }
                else if(primaryCode==114){
                    code = "@";

                }

                else if(primaryCode==115){
                    code = "#";
                }

                else if(primaryCode==116){
                    code = "$";
                }

                else if(primaryCode==117){
                    code = "%";
                }




                else code="m";
                ic.commitText(code,1);
        }
    }
    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch(keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }


}