package br.com.fiap.dao;

import br.com.fiap.to.ServicosTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicosDAO extends Repository{
    public ArrayList<ServicosTO> findAll(){

        ArrayList<ServicosTO> servicos = new ArrayList<>();
        String sql = "SELECT * FROM ddd_servicos ORDER BY id_servicos";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    ServicosTO servico = new ServicosTO();
                    servico.setId_servicos(rs.getLong("id_servicos"));
                    servico.setPlaca(rs.getString("placa"));
                    servico.setMotivo(rs.getString("motivo"));
                    servico.setValor(rs.getDouble("valor"));
                    servico.setDt_entrada(rs.getDate("dt_entrada").toLocalDate());
                    servico.setDt_saida(rs.getDate("dt_saida").toLocalDate());
                    servicos.add(servico);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return servicos;
    }

    public ServicosTO findByCodigo(Long id_servicos){
        ServicosTO servico = null;
        String sql = "SELECT * FROM ddd_servicos WHERE id_servicos = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_servicos);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    servico = new ServicosTO();
                    servico.setId_servicos(rs.getLong("id_servicos"));
                    servico.setPlaca(rs.getString("placa"));
                    servico.setMotivo(rs.getString("motivo"));
                    servico.setValor(rs.getDouble("valor"));
                    servico.setDt_entrada(rs.getDate("dt_entrada").toLocalDate());
                    servico.setDt_saida(rs.getDate("dt_saida").toLocalDate());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return servico;
    }

    public ServicosTO save(ServicosTO servico){
        String sql = "insert into ddd_servicos(placa, motivo, valor, dt_entrada, dt_saida) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, servico.getPlaca());
            ps.setString(2, servico.getMotivo());
            ps.setDouble(3, servico.getValor());
            ps.setDate(4, Date.valueOf(servico.getDt_entrada()));
            ps.setDate(5, Date.valueOf(servico.getDt_saida()));

            if (ps.executeUpdate() > 0) {
                return servico;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_servicos){
        String sql = "delete from ddd_servicos where id_servicos = ?";
        //abrindo conexão com o banco, garante a liberação do recurso que o preparedStatment vai liberar
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_servicos);
            return ps.executeUpdate() > 0; //vai executar o comando e comparar se é menor que zero, se for maior que zero retorna true - quando da verdadeiro significa que deu certo e conseguiu apagar
        } catch (SQLException e) {
            System.out.printf("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection(); //de qualquer forma fecha a comexão
        }
        return false; //se ele chegou até aqui significa que ele não conseguiu apagar. mas é muito dificil ele chegar nessa linha
    }

    public ServicosTO update(ServicosTO servico) throws SQLException {
        String sql = "update ddd_servicos set placa =?, motivo =?, valor =?, dt_entrada =?, dt_saida =? where id_servicos=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, servico.getPlaca());
            ps.setString(2, servico.getMotivo());
            ps.setDouble(3, servico.getValor());
            ps.setDate(4, Date.valueOf(servico.getDt_entrada()));
            ps.setDate(5, Date.valueOf(servico.getDt_saida()));
            ps.setLong(6, servico.getId_servicos());
            if (ps.executeUpdate() > 0){
                return servico;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
