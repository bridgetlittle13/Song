package sg.edu.rp.c346.id22013272.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText etTitle,etName,etYear;
Button btnInsert,btnSL;
ArrayList<song> alSong;
ArrayAdapter<song>aaSong;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle=findViewById(R.id.editTextTitle);
        etName=findViewById(R.id.editTextSinger);
        etYear=findViewById(R.id.editTextYear);
        btnInsert=findViewById(R.id.buttonInsert);
        btnSL=findViewById(R.id.buttonSL);
        alSong=new ArrayList<>();
        aaSong=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alSong);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db= new DBHelper(MainActivity.this);
                String title=etTitle.getText().toString();
                String name=etName.getText().toString();
                String year=etYear.getText().toString();
                db.insertTask(title,name,year);


            }
        });
        btnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data=db.getSongContent();
                ArrayList<song> data1=db.getSongs();
                alSong.addAll(data1);
                aaSong.notifyDataSetChanged();
                db.close();

                String txt="";
                for (int i=0;i<data.size();i++){
                    Log.d("Database Content",i+". "+data.get(i));
                    txt+=i+". "+data.get(i)+"\n";
                }
                tv.setText(txt);

            }
        });

    }


}