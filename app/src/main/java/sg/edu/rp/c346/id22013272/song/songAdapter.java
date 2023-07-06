package sg.edu.rp.c346.id22013272.song;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class songAdapter extends ArrayAdapter<song> {
    private ArrayList<song> songs;

    public songAdapter(Context context, ArrayList<Parcelable> songs) {
        super(context, 0, songs);
        this.songs = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main2, parent, false);
        }

        song currentSong = songs.get(position);

        TextView titleTextView = listItemView.findViewById(R.id.textViewTitle);
        TextView singerTextView = listItemView.findViewById(R.id.textViewSing);
        TextView yearTextView = listItemView.findViewById(R.id.textViewYear);
        titleTextView.setText(currentSong.getTitle());
        singerTextView.setText(currentSong.getName());
        yearTextView.setText(currentSong.getYear());

        return listItemView;
    }
}
