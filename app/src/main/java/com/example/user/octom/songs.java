package com.example.user.octom;

public class songs {

    String PrimeCupletSource;
    int MP3SourcePlus, MP3SourceMinus;
    String title, author;
    String webSource;
    String TintSource;
    private int mImageResource;

    public songs(int ImageResource, String title, String author, String PrimeCupletSource, String TintSource, String webSource, int MP3SourcePlus, int MP3SourceMinus) {
        this.mImageResource = ImageResource;
        this.title = title;
        this.author = author;
        this.PrimeCupletSource = PrimeCupletSource;
        this.TintSource = TintSource;
        this.webSource = webSource;
        this.MP3SourcePlus = MP3SourcePlus;
        this.MP3SourceMinus = MP3SourceMinus;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getTintSource() {return TintSource;}

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPrimeCuplet() {
        return PrimeCupletSource;
    }

    public String getWebSource() {
        return webSource;
    }

    public void setWebSource(String LastText) {
        this.webSource = LastText;
    }

    public int getMP3SourcePlus() {
        return MP3SourcePlus;
    }

    public void setMP3SourcePlus(int MP3SourcePlus) {
        this.MP3SourcePlus = MP3SourcePlus;
    }

    public int getMP3SourceMinus() {
        return MP3SourceMinus;
    }

    public void setMP3SourceMinus(int MP3SourceMinus) {
        this.MP3SourcePlus = MP3SourceMinus;
    }

}
