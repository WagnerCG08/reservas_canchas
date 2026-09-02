package com.reservas.reservasCanchas.repository;

import com.reservas.reservasCanchas.entity.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<cliente, Long> {
}