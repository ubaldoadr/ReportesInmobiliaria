package cl.praxis.api;

import cl.praxis.models.Proyecto;
import cl.praxis.service.IProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoRestController {
    private final IProyecto service;

    public ProyectoRestController(IProyecto service) {
        this.service = service;
    }

    private HttpStatus status = HttpStatus.OK;

    @GetMapping
    public ResponseEntity<List<Proyecto>> findAll(){
        List<Proyecto> proyectos = service.findAll();

        if (proyectos == null || proyectos.size() == 0){
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(proyectos, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> findOne(@PathVariable("id") int id){
        Proyecto proyecto = service.findOne(id);

        if (proyecto == null){
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(proyecto, status);
    }

    @PostMapping
    public boolean create(@RequestBody Proyecto proyecto){

        return service.create(proyecto);

    }

    @PutMapping ("/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody  Proyecto proyecto) {

        return  service.update(id, proyecto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return  service.delete(id);

    }
}