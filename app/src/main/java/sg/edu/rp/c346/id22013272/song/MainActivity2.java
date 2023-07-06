package sg.edu.rp.c346.id22013272.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lvSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvSong=findViewById(R.id.lv);
        ArrayList<Parcelable> songData = getIntent().getParcelableArrayListExtra("songData");
        if (songData != null && songData.size()> 0) {
            songAdapter songAdapter = new songAdapter(this, songData);
            lvSong.setAdapter(songAdapter);
        }

    }
}