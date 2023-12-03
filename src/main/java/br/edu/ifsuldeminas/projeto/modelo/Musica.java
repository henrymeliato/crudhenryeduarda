package br.edu.ifsuldeminas.projeto.modelo;

public class Musica {
    private String titulo;
    private String album;
    private String artista;
    private int musicaID;

    public int getMusicaID() {
        return musicaID;
    }

    public void setMusicaID(int musicaID) {
        this.musicaID = musicaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}