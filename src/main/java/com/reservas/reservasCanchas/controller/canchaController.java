package com.reservas.reservasCanchas.controller;

import com.reservas.reservasCanchas.entity.cancha;
import com.reservas.reservasCanchas.repository.canchaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canchas")
public class canchaController {

    private final canchaRepository repository;

    public canchaController(canchaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<cancha> listar() {
        return repository.findAll();
    }

    @PostMapping
    public cancha crear(@RequestBody cancha cancha) {
        return repository.save(cancha);
    }

    @GetMapping("/{id}")
    public cancha obtener(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public cancha actualizar(@PathVariable Long id, @RequestBody cancha datos) {
        cancha cancha = repository.findById(id).orElseThrow();
        cancha.setNombre(datos.getNombre());
        cancha.setTipo(datos.getTipo());
        cancha.setPrecioPorHora(datos.getPrecioPorHora());
        return repository.save(cancha);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}