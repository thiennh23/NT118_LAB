package com.example.lab05task4;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnStream, btnStop;
    EditText etURL;
    Boolean isStreaming = false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etURL = findViewById(R.id.etURL);
        btnStream = findViewById(R.id.btnStream);
        btnStop = findViewById(R.id.btnStop);

        btnStream.setOnClickListener(view -> {
            String url = etURL.getText().toString();
            new MediaPlayerAsyncTask().execute(url);
        });

        btnStop.setOnClickListener(view -> stopPlaying());
    }

    private void startAudioStream(String url) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.setVolume(3f, 3f);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        } catch (Exception e) {
            Log.d("mylog", "Error playing in SoundHandler: " + e.toString());
        }
    }

    private void stopPlaying() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private class MediaPlayerAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... urls) {
            String mp3Url = urls[0];
            startAudioStream(mp3Url);
            return null;
        }
    }
}
