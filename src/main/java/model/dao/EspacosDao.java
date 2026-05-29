package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DB.DB;
import model.classes.Espacos;

public class EspacosDao {

    private Connection con;

    public EspacosDao(Connection con) {
        this.con = con;
    }

    public List<Espacos> getAll() {
        List<Espacos> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select * from espaco";
            stmt = con.prepareStatement(sql);

            res = stmt.executeQuery();
            while (res.next()) {
                Espacos espaco = new Espacos(res.getInt("pk_cod_espaco"),
                        res.getString("nome"),
                        res.getString("descricao"),
                        res.getInt("numero"));
                System.out.println(espaco);
                list.add(espaco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(res);
            DB.closeStatement(stmt);
            return list;
        }

    }

    public boolean inserir(Espacos espaco) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "insert into espaco (pk_cod_espaco, "
                       + "nome, "
                       + "descricao, "
                       + "numero) "
                       + " values (?, ?, ?, ?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, espaco.getCodEspaco());
            stmt.setString(2, espaco.getNome());
            stmt.setString(3, espaco.getDescricao());
            stmt.setInt(4, espaco.getNumero());

            stmt.executeUpdate();

            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }

    public boolean editar(Espacos espaco) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "update espaco set nome = ?, "
                    + " descricao = ?, "
                    + " numero = ? "
                    + " where pk_cod_espaco = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, espaco.getNome());
            stmt.setString(2, espaco.getDescricao());
            stmt.setInt(3, espaco.getNumero());
            stmt.setInt(4, espaco.getCodEspaco());
            stmt.executeUpdate();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }

    public boolean excluir(Espacos espaco) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "delete from espaco where pk_cod_espaco = ?";
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, espaco.getCodEspaco());
            
            
            
            stmt.executeUpdate();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }
}
