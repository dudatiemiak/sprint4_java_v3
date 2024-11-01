package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository{
    public ArrayList<UsuarioTO> findAll(){
        ArrayList<UsuarioTO> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM ddd_usuarios ORDER BY id_usuario";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setId_usuario(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuarios.add(usuario);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findByCodigo(Long id_usuario){
        UsuarioTO usuario = null;
        String sql = "SELECT * FROM ddd_usuarios WHERE id_usuario = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_usuario);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    usuario = new UsuarioTO();
                    usuario.setId_usuario(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setCpf(rs.getString("cpf"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario){
        String sql = "insert into ddd_usuarios(nome, email, senha, cpf) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getCpf());

            if (ps.executeUpdate() > 0) {
                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_usuario){
        String sql = "delete from ddd_usuarios where id_usuario = ?";
        //abrindo conexão com o banco, garante a liberação do recurso que o preparedStatment vai liberar
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_usuario);
            return ps.executeUpdate() > 0; //vai executar o comando e comparar se é menor que zero, se for maior que zero retorna true - quando da verdadeiro significa que deu certo e conseguiu apagar
        } catch (SQLException e) {
            System.out.printf("Erro ao excluir: " + e.getMessage());
        }finally {
            closeConnection(); //de qualquer forma fecha a comexão
        }
        return false; //se ele chegou até aqui significa que ele não conseguiu apagar. mas é muito dificil ele chegar nessa linha
    }

    public UsuarioTO update(UsuarioTO usuario) throws SQLException {
        String sql = "update ddd_usuarios set nome =?, email =?, senha =?, cpf =? where id_usuario=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getCpf());
            ps.setLong(5, usuario.getId_usuario());
            if (ps.executeUpdate() > 0){
                return usuario;
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
