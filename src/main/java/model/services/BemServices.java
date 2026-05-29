package model.services;

import java.util.List;
import model.DB.DB;
import model.classes.Bem;
import model.classes.Espacos;
import model.dao.BemDao;

public class BemServices {

    private BemDao dao = new BemDao(DB.getConnection());

    public List<Bem> getAll() {
        return dao.getAll();
    }

    public List<Bem> getAll(Espacos espaco) {
        return dao.getAll();
    }

    public boolean inserir(Bem bem) {
            return dao.inserir(bem);
    }

    public boolean editar(Bem bem) {
            return dao.editar(bem);
    }

    public boolean excluir(Bem bem) {
        return dao.excluir(bem);
    }
    
}
