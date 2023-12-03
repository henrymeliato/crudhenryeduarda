package br.edu.ifsuldeminas.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifsuldeminas.projeto.modelo.Artista;


public class ArtistaDAO {
    public void setArtista(Artista artista){
        String sql = "INSERT INTO Artista (ArtistaNome, idade) VALUES (?, ?)";
    
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, artista.getArtistaNome());
            ps.setInt(2, artista.getIdade());

            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Artista> getArtistas(){
        String sql = "SELECT ArtistaNome, idade FROM crudhm.artista;";
        List<Artista> listaArtistas = new ArrayList<>();

        try {
            
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Artista artista = new Artista();

                artista.setArtistaNome(rs.getString("ArtistaNome"));
                artista.setIdade(rs.getInt("idade"));

                listaArtistas.add(artista);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }       

        return listaArtistas;
    }

}
