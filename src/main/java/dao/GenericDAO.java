package dao;

import java.util.List;

public interface GenericDAO <T, ID> {
    void inserir (T entidade);
    abstract List<T> Listar();
}
