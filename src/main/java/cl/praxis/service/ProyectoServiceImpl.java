package cl.praxis.service;

import cl.praxis.models.Proyecto;
import cl.praxis.repsository.ProyectoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProyectoServiceImpl implements IProyecto{


    ProyectoRepository repository;

    public ProyectoServiceImpl(ProyectoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Proyecto> findAll() {
        log.warn("pasando por ProductoServiceImpl findAll");
        return repository.findAll();
    }

    @Override
    public Proyecto findOne(int id) {
        log.warn("pasando por ProductoServiceImpl findOne");
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Proyecto p) {
        log.warn("pasando por ProductoServiceImpl create");
       Proyecto proyecto= repository.save(p);

        System.out.println("creado el id " + proyecto.getId());

        return proyecto != null;
    }

    @Override
    public boolean update(int id, Proyecto p) {
        log.warn("pasando por ProductoServiceImpl update");
        Proyecto proyecto= findOne(id);
        proyecto.setName(p.getName());
        proyecto.setContact(p.getContact());
        proyecto.setStatus(p.getStatus());
        repository.save(proyecto);

        return proyecto != null;
    }

    @Override
    public boolean delete(int id) {
        log.warn("pasando por ProductoServiceImpl delete");
        boolean exist = repository.existsById(id);
        if (exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
