package com.reservas.reservasCanchas.repository;

import com.reservas.reservasCanchas.entity.cancha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface canchaRepository extends JpaRepository<cancha, Long> {
}