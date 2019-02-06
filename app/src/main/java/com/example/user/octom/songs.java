package com.example.user.octom;

public class songs {

    String title, author;
    String PrimeCupletSource, PrimePripevSource, LastTextSource, MP3Source;
    private int mImageResource;

    public songs(int ImageResource, String title, String author, String PrimeCupletSource, String PrimePripevSource, String LastTextSource, String MP3Source) {
        this.mImageResource = ImageResource;
        this.title = title;
        this.author = author;
        this.PrimeCupletSource = PrimeCupletSource;
        this.PrimePripevSource = PrimePripevSource;
        this.LastTextSource = LastTextSource;
        this.MP3Source = MP3Source;
    }

    public int getmImageResource() { return mImageResource;}

    public void setmImageResource(int mImageResource) { this.mImageResource = mImageResource;}

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

    public void setPrimeCuplet(String PrimeCuplet) {this.PrimeCupletSource = PrimeCuplet;}

    public String getPrimePripev() {
        return PrimePripevSource;
    }

    public void setPrimePripev(String PrimePripev) {
        this.PrimePripevSource = PrimePripev;
    }

    public String getLastText() { return LastTextSource;}

    public void setLastText(String LastText) {this.LastTextSource = LastText;}

    public String getmImages() { return LastTextSource;}

    public void setmImages(String LastText) { this.LastTextSource = LastText;}

    public String getMP3Source() { return MP3Source;}

    public void setMP3Source(String LastText) { this.MP3Source = LastText;}

}
