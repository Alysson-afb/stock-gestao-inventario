package model.services;

import java.util.List;
import model.DB.DB;
import model.classes.Espacos;
import model.dao.EspacosDao;

public class EspacosService {

    private EspacosDao dao = new EspacosDao(DB.getConnection());

    public List<Espacos> getAll() {
        return dao.getAll();
    }

    public boolean inserir(Espacos espaco) {
        return dao.inserir(espaco);
    }

    public boolean editar(Espacos espaco) {
        return dao.editar(espaco);
    }

    public boolean excluir(Espacos espaco) {
        return dao.excluir(espaco);
    }
}
