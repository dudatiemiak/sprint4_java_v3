package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository {
    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM ddd_veiculos ORDER BY id_veiculo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setId_veiculo(rs.getLong("id_veiculo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setTipo(rs.getString("tipo"));
                    veiculo.setQuilometragem(rs.getDouble("quilometragem")); // Alterado para Double
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setAno(rs.getInt("ano"));
                    veiculos.add(veiculo);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculoTO findByCodigo(Long id_veiculo) {
        VeiculoTO veiculo = null;
        String sql = "SELECT * FROM ddd_veiculos WHERE id_veiculo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_veiculo);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    veiculo = new VeiculoTO();
                    veiculo.setId_veiculo(rs.getLong("id_veiculo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setTipo(rs.getString("tipo"));
                    veiculo.setQuilometragem(rs.getDouble("quilometragem"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setAno(rs.getInt("ano"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "INSERT INTO ddd_veiculos (placa, tipo, quilometragem, marca, modelo, ano) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getTipo());
            ps.setDouble(3, veiculo.getQuilometragem()); // Alterado para Double
            ps.setString(4, veiculo.getMarca());
            ps.setString(5, veiculo.getModelo());
            ps.setInt(6, veiculo.getAno());
            if (ps.executeUpdate() > 0) {
                return veiculo;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_veiculo) {
        String sql = "DELETE FROM ddd_veiculos WHERE id_veiculo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_veiculo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        String sql = "UPDATE ddd_veiculos SET placa = ?, tipo = ?, quilometragem = ?, marca = ?, modelo = ?, ano = ? WHERE id_veiculo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getTipo());
            ps.setDouble(3, veiculo.getQuilometragem()); // Alterado para Double
            ps.setString(4, veiculo.getMarca());
            ps.setString(5, veiculo.getModelo());
            ps.setInt(6, veiculo.getAno());
            ps.setLong(7, veiculo.getId_veiculo());

            if (ps.executeUpdate() > 0) {
                return veiculo;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
