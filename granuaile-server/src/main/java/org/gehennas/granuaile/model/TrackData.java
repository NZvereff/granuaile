package org.gehennas.granuaile.model;

public class TrackData {

    private final int id;
    private final String name;
    private final String album;
    private final int year;
    private final String artist;

    public TrackData(int id, String name, String album, int year, String artist) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.year = year;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }
}
