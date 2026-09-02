package com.reservas.reservasCanchas.controller;

import com.reservas.reservasCanchas.entity.cliente;
import com.reservas.reservasCanchas.repository.clienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    private final clienteRepository repository;

    public clienteController(clienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<cliente> listar() {
        return repository.findAll();
    }

    @PostMapping
    public cliente crear(@RequestBody cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    public cliente obtener(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public cliente actualizar(@PathVariable Long id, @RequestBody cliente datos) {
        cliente cliente = repository.findById(id).orElseThrow();
        cliente.setNombre(datos.getNombre());
        cliente.setTelefono(datos.getTelefono());
        cliente.setEmail(datos.getEmail());
        return repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}