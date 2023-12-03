package br.edu.ifsuldeminas.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.projeto.modelo.Musica;

public class PlaylistDAO {
    public static List<Musica> getMusicas() {
        ArrayList<Musica> listaMusicas = new ArrayList<>();
        String sql = "SELECT titulo, album, artista FROM crudhm.musica;";

        try {
            
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Musica musica = new Musica();

                musica.setTitulo(rs.getString("titulo"));
                musica.setAlbum(rs.getString("album"));
                musica.setArtista(rs.getString("artista"));

                listaMusicas.add(musica);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }       

        return listaMusicas;
    }
}
