package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DB.DB;
import model.classes.Bem;
import model.classes.Espacos;

public class BemDao {

    private Connection con;

    public BemDao(Connection con) {
        this.con = con;
    }

    public List<Bem> getAll() {
        List<Bem> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select bem.*, "
                       + "espaco.pk_cod_espaco, "
                       + "espaco.nome AS espaconome, "
                       + "espaco.descricao AS espacodescricao, "
                       + "espaco.numero from bem \n"
                       + "join espaco on (espaco.pk_cod_espaco = bem.fk_cod_espaco)";
            stmt = con.prepareStatement(sql);

            res = stmt.executeQuery();
            while (res.next()) {
                Bem bem = new Bem
                        (res.getInt("pk_cod_bem"),
                         res.getString("categoria"),
                         res.getString("nome"),
                         res.getString("descricao"),
                         res.getFloat("valor"),
                         res.getDate("data_aquisicao").toLocalDate(),
                         res.getInt("estado_conservacao"),
                                
                new Espacos(res.getInt("pk_cod_espaco"),
                            res.getString("espaconome"),
                            res.getString("espacodescricao"),
                            res.getInt("numero")));
                System.out.println(bem);
                list.add(bem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(res);
            DB.closeStatement(stmt);
            return list;
        }
    }

        public List<Bem> getAll(Espacos espaco) {
        List<Bem> list = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select bem.*, "
                       + "espaco.pk_cod_espaco, "
                       + "espaco.nome AS espaconome, "
                       + "espaco.descricao AS espacodescricao, "
                       + "espaco.numero from bem \n"
                       + "join espaco on (espaco.pk_cod_espaco = bem.fk_cod_espaco) "
                       + " espaco.pk_cod_espaco = "+espaco.getCodEspaco();
            stmt = con.prepareStatement(sql);

            res = stmt.executeQuery();
            while (res.next()) {
                Bem bem = new Bem
                        (res.getInt("pk_cod_bem"),
                         res.getString("categoria"),
                         res.getString("nome"),
                         res.getString("descricao"),
                         res.getFloat("valor"),
                         res.getDate("data_aquisicao").toLocalDate(),
                         res.getInt("estado_conservacao"),
                                
                new Espacos(res.getInt("pk_cod_espaco"),
                            res.getString("espaconome"),
                            res.getString("espacodescricao"),
                            res.getInt("numero")));
                System.out.println(bem);
                list.add(bem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(res);
            DB.closeStatement(stmt);
            return list;
        }
    }

    
    public boolean inserir(Bem bem) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "insert into bem (categoria, "
                       + "nome, "
                       + "descricao, "
                       + "valor, "
                       + "data_aquisicao, "
                       + "estado_conservacao, "
                       + "fk_cod_espaco) "
                       + " values (?,?,?,?,?,?,?)";

            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, bem.getCategoria());
            stmt.setString(2, bem.getNome());
            stmt.setString(3, bem.getDescricao());
            stmt.setFloat(4, bem.getValor());
            stmt.setDate(5, Date.valueOf(bem.getDataAquisicao()));
            stmt.setInt(6, bem.getEstadoConservacao());
            stmt.setInt(7, bem.getEspaco().getCodEspaco());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    bem.setCodBem(id);
                    result = true;
                }
            } else {
                throw new SQLException("Não foi possível inserir");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }

    public boolean editar(Bem bem) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = "update bem set nome = ?, "
                       + " categoria = ?, "
                       + " descricao = ?, "
                       + " valor = ?, "
                       + " data_aquisicao = ?, "
                       + " estado_conservacao = ? "
                       + " where pk_cod_bem = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, bem.getNome());
            stmt.setString(2, bem.getCategoria());
            stmt.setString(3, bem.getDescricao());
            stmt.setFloat(4, bem.getValor());
            stmt.setDate(5, Date.valueOf(bem.getDataAquisicao()));
            stmt.setInt(6, bem.getEstadoConservacao());
            stmt.setInt(7, bem.getCodBem());
            stmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(stmt);
            return result;
        }
    }

    public boolean excluir(Bem bem) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {
            String sql = 
                    "delete from bem where pk_cod_bem = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, bem.getCodBem());
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
