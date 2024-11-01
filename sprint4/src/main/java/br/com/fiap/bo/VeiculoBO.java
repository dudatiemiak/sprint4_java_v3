package br.com.fiap.bo;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.to.VeiculoTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoBO {
    private VeiculoDAO veiculoDAO;

    public ArrayList<VeiculoTO> findAll() {
        veiculoDAO = new VeiculoDAO();
        //aqui se implementa a regra de negócios
        return  veiculoDAO.findAll();
    }

    public VeiculoTO findByCodigo(Long id_veiculo) {
        veiculoDAO = new VeiculoDAO();
        // aqui se implementa a regra de negócios
        return veiculoDAO.findByCodigo(id_veiculo);
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        //aqui se implementa a regra de negócios
//        if (!oficina.getDataDeFabricacao().isBefore(LocalDate.now())) { // se não for
//            return null;
//        }
//        if (!oficina.getDataDeValidade().isAfter(LocalDate.now())) { // se não for
//            return null;
//        }
        return veiculoDAO.save(veiculo);
    }

    public  boolean delete(Long id_veiculo){
        veiculoDAO = new VeiculoDAO();
        //aqui se implementa a regra de negócios
        return veiculoDAO.delete(id_veiculo);
    }

    public VeiculoTO update(VeiculoTO veiculo) throws SQLException {
        veiculoDAO = new VeiculoDAO();
        //aqui se implementa a regra de negócios
        return veiculoDAO.update(veiculo);
    }
}
