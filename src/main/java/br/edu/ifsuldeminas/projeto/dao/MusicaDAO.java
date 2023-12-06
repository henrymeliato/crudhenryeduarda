/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsuldeminas.projeto.dao;

import br.edu.ifsuldeminas.projeto.modelo.Musica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;

/**
 *
 * @author 11627651608
 */
public class MusicaDAO {
    
    public void CadastrarMusica(Musica musica) {
        String sql = "INSERT INTO Musica (musicaID, titulo, album, artista) VALUES (?, ?, ?, ?)";
    
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, musica.getMusicaID());
            ps.setString(2, musica.getTitulo());
            ps.setString(3, musica.getAlbum());
            ps.setString(4, musica.getArtista());

            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public int getMusicaID(String nomeMusica) {
        String sql = "SELECT musicaID FROM crudhm.musica WHERE titulo = ?";
        int result = 0;
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nomeMusica);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt(1);
            }

            ps.close();
            
            return result;

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void editMusica(Musica musica, int idMusica) {
        String sql = "UPDATE crudhm.musica SET musicaID = ?, titulo = ?, album = ?, artista = ? WHERE musicaID = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, musica.getMusicaID());
            ps.setString(2, musica.getTitulo());
            ps.setString(3, musica.getAlbum());
            ps.setString(4, musica.getArtista());
            ps.setInt(5, idMusica);

            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
