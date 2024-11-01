package br.com.fiap.bo;

import br.com.fiap.dao.ServicosDAO;
import br.com.fiap.to.ServicosTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServicosBO {
    private ServicosDAO servicosDAO;

    public ArrayList<ServicosTO> findAll() {
        servicosDAO = new ServicosDAO();
        //aqui se implementa a regra de negócios
        return  servicosDAO.findAll();
    }

    public ServicosTO findByCodigo(Long id_servicos) {
        servicosDAO = new ServicosDAO();
        // aqui se implementa a regra de negócios
        return servicosDAO.findByCodigo(id_servicos);
    }

    public ServicosTO save(ServicosTO servicos) {
        servicosDAO = new ServicosDAO();
        //aqui se implementa a regra de negócios
//        if (!oficina.getDataDeFabricacao().isBefore(LocalDate.now())) { // se não for
//            return null;
//        }
//        if (!oficina.getDataDeValidade().isAfter(LocalDate.now())) { // se não for
//            return null;
//        }
        return servicosDAO.save(servicos);
    }

    public  boolean delete(Long id_servicos){
        servicosDAO = new ServicosDAO();
        //aqui se implementa a regra de negócios
        return servicosDAO.delete(id_servicos);
    }

    public ServicosTO update(ServicosTO servicos) throws SQLException {
        servicosDAO = new ServicosDAO();
        //aqui se implementa a regra de negócios
        return servicosDAO.update(servicos);
    }
}
