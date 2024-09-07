package com.example.storybooksforkids;

import static android.speech.tts.TextToSpeech.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.http.UrlRequest;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class story_Activity extends AppCompatActivity {

    public static String STORY ="";
    public static String TITLE ="";

    public static String MORAL ="";

    public static int image_story =0;

    TextToSpeech textToSpeech;

    ImageView bgImage;

    TextView tvStoryTitle,tvStory,tvMoral;

    ImageButton btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        bgImage=findViewById(R.id.bgImage);
        tvStoryTitle=findViewById(R.id.tvStoryTitle);
        tvStory=findViewById(R.id.tvStory);
        tvMoral=findViewById(R.id.tvMoral);
        btnPlay=findViewById(R.id.btnPlay);

        bgImage.setImageResource(image_story);

        tvStoryTitle.setText(TITLE);
        tvStory.setText(STORY);
        tvMoral.setText(MORAL);

        textToSpeech = new TextToSpeech(story_Activity.this, new OnInitListener() {
            @Override
            public void onInit(int status) {


            }
        });

        btnPlay.setOnClickListener(v -> {
            String text = tvStory.getText().toString();
            String moral = tvMoral.getText().toString();

             textToSpeech.speak(text, QUEUE_FLUSH,null,null);



        });
    }


    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }
}