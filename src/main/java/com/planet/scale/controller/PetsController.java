package com.planet.scale.controller;

import com.planet.scale.model.Pets;
import com.planet.scale.model.response.Response;
import com.planet.scale.repository.IPetsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/mascotas")
public class PetsController {

    private final IPetsRepository _repository;

    public PetsController(IPetsRepository repository) {
        this._repository = repository;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Response<Iterable<Pets>>> getAll() {
        var res = new Response<Iterable<Pets>>();
        try {
            res.Message = "data returned";
            res.Data = _repository.findAll();
            return ResponseEntity.ok(res);
        } catch (Exception ex) {
            res.Message = "Ha ocurrido un Error al momento de traer todos los datos";
            return ResponseEntity.status(500).body(res);
        }
    }

    @GetMapping(path = "/ver/{id}")
    public ResponseEntity<Response<Optional<Pets>>> getOne(@PathVariable Integer id) {
        var res = new Response<Optional<Pets>>();
        try {
            res.Message = "se ha listado el registro #" + id;
            res.Data = _repository.findById(id);
            return ResponseEntity.status(200).body(res);
        } catch (Exception ex) {
            res.Message = "Ha ocurrido un Error al lista un dato";
            return ResponseEntity.status(500).body(res);
        }
    }

    @GetMapping(path = "/get/report")
    public @ResponseBody Object getReport() {
        var ltsData =  _repository.getPetsReport();
        Map<String, String> ltsMap = new HashMap<>();
        for (var data: ltsData) {
            ltsMap.put(data.getPropietario(), data.getNombre());
        }
        return ltsMap;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Response<Pets>> insert(@RequestBody Pets pets) {
        var res = new Response<Pets>();
        try {
            _repository.save(pets);
            res.Message = "Se ha registrado correctamente todo sobre el registro #" + pets.getId();
            res.Data = pets;
            return ResponseEntity.status(201).body(res);
        } catch (Exception ex) {
            res.Message = "Ha ocurrido un Error al ingresar un registro";
            return ResponseEntity.status(500).body(res);
        }
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Response<Pets>> update(@RequestBody Pets pets) {
        var res = new Response<Pets>();
        try {
            res.Message = "Se ha actualizado el registro #" + pets.getId() + " Correctamente";
            _repository.save(pets);
            res.Data = pets;
            return ResponseEntity.status(200).body(res);
        } catch (Exception ex) {
            res.Message = "Ha ocurrido un error al actualizar el registro #" + pets.getId();
            return ResponseEntity.status(500).body(res);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Response<Pets>> delete(@RequestBody Pets pets) {
        var res = new Response<Pets>();
        try {
            res.Message = "Se ha eliminar el registro #" + pets.getId();
            _repository.delete(pets);
            return ResponseEntity.status(204).body(res);
        } catch (Exception ex) {
            res.Message = "No se ha podido eliminar el registro #" + pets.getId();
            return ResponseEntity.status(500).body(res);
        }
    }
}
