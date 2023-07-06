package sg.edu.rp.c346.id22013272.song;

import androidx.annotation.NonNull;

public class song {
    private int id;
    private String title;
    private String name;
    private String year;
    public song(int id, String title, String name, String year) {
        this.id=id;
        this.title=title;
        this.name=name;
        this.year=year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }
    @NonNull
    @Override
    public String toString(){
    return id+"\n"+title+"\n"+name+"\n"+year;
    }
}
