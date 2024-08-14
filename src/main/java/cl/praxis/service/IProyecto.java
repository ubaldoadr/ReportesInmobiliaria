package cl.praxis.service;

import cl.praxis.models.Proyecto;

import java.util.List;

public interface IProyecto {

    List<Proyecto> findAll();
    Proyecto findOne(int id);
    boolean create(Proyecto p);
    boolean update(int id,Proyecto p);
    boolean delete(int id);
}
